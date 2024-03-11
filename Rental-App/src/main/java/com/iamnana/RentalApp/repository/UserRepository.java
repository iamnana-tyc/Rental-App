package com.iamnana.RentalApp.repository;

import com.iamnana.RentalApp.dto.AppUserDto;
import com.iamnana.RentalApp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findFirstByEmail(String email);
}
