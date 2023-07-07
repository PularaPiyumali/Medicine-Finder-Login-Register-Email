package com.medifinder.LoginRegisterEmail.repository;

import com.medifinder.LoginRegisterEmail.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
}
