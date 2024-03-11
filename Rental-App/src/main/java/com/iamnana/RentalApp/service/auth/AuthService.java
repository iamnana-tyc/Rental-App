package com.iamnana.RentalApp.service.auth;

import com.iamnana.RentalApp.dto.SignUpRequest;
import com.iamnana.RentalApp.dto.AppUserDto;

public interface AuthService {
    AppUserDto createCustomer(SignUpRequest signUpRequest);
    boolean hasCustomerWithSameEmail(String email);
}
