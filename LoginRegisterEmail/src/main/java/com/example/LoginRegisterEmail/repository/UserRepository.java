package com.example.LoginRegisterEmail.repository;

import com.example.LoginRegisterEmail.entities.User;
import com.example.LoginRegisterEmail.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);



}
