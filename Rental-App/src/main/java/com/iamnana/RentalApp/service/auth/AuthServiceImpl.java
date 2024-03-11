package com.iamnana.RentalApp.service.auth;

import com.iamnana.RentalApp.dto.SignUpRequest;
import com.iamnana.RentalApp.dto.AppUserDto;
import com.iamnana.RentalApp.enums.UserRoles;
import com.iamnana.RentalApp.model.AppUser;
import com.iamnana.RentalApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    @Override
    public AppUserDto createCustomer(SignUpRequest signUpRequest) {
        AppUser user = new AppUser();

        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setUserRoles(UserRoles.CUSTOMER);

        AppUser savedUser =  userRepository.save(user);

        AppUserDto userDto = new AppUserDto();
        userDto.setId(savedUser.getId());

        return userDto;
    }

    @Override
    public boolean hasCustomerWithSameEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
