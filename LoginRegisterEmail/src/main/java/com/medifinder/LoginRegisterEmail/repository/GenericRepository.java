package com.medifinder.LoginRegisterEmail.repository;

import com.medifinder.LoginRegisterEmail.entities.Generic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepository extends JpaRepository<Generic,Long> {
}
