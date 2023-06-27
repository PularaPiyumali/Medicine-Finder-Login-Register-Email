package com.example.LoginRegisterEmail.repository;

import com.example.LoginRegisterEmail.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
}
