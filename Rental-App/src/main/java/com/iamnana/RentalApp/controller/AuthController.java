package com.iamnana.RentalApp.controller;

import com.iamnana.RentalApp.dto.SignUpRequest;
import com.iamnana.RentalApp.dto.AppUserDto;
import com.iamnana.RentalApp.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<?> saveCustomer(@RequestBody SignUpRequest signUpRequest){
        if(authService.hasCustomerWithSameEmail(signUpRequest.getEmail()))
            return new ResponseEntity<>("customer with same email exist!", HttpStatus.NOT_ACCEPTABLE);
       AppUserDto savedUserDto =  authService.createCustomer(signUpRequest);
       if(savedUserDto == null)
           return new ResponseEntity<>("customer can't be saved,try again!", HttpStatus.BAD_REQUEST);
       return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
    }
}
