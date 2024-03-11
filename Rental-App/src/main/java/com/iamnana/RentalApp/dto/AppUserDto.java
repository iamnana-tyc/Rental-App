package com.iamnana.RentalApp.dto;

import com.iamnana.RentalApp.enums.UserRoles;
import lombok.Data;

@Data
public class AppUserDto {
    private Long id;
    private String name;
    private String email;
    private UserRoles userRoles;
}
