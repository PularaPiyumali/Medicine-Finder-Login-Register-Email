package com.example.LoginRegisterEmail.repository;

import com.example.LoginRegisterEmail.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <Customer,Long> {
}
