package com.drug.drugbooking.repository;

import com.drug.drugbooking.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);
}
