package com.example.LoginRegisterEmail.services;

import com.example.LoginRegisterEmail.entities.Medicine;
import com.example.LoginRegisterEmail.exceptions.MedicineNotFoundException;
import com.example.LoginRegisterEmail.repoistory.MedicineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
@AllArgsConstructor
public class MedicineService implements Serializable {

    private MedicineRepository medicineRepository;
    public Medicine addMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public Medicine findMedicineName(String medicineName) {
        return medicineRepository.findByMedicineName(medicineName).orElseThrow(() -> new MedicineNotFoundException(medicineName + "was not found"));

    }


    @Transactional
    public void deleteMedicine(Long medicineId) {
        medicineRepository.deleteMedicineByMedicineId(medicineId);
    }
}
