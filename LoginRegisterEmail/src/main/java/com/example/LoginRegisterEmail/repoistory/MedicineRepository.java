package com.example.LoginRegisterEmail.repoistory;

import com.example.LoginRegisterEmail.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    Optional<Medicine> findByMedicineName(String medicineName);

    void deleteMedicineByMedicineId(@Param("medicineId") Long medicineId);
}


