package com.medifinder.LoginRegisterEmail.repository;

import com.medifinder.LoginRegisterEmail.entities.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy,Long> {
}
