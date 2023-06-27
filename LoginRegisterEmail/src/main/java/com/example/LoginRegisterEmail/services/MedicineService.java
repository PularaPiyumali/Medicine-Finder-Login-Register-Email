package com.example.LoginRegisterEmail.services;

import com.example.LoginRegisterEmail.Requests.GenericMedicineRequest;
import com.example.LoginRegisterEmail.Requests.UpdateMedicineRequest;
import com.example.LoginRegisterEmail.entities.Generic;
import com.example.LoginRegisterEmail.entities.Medicine;
import com.example.LoginRegisterEmail.exceptions.MedicineNotFoundException;
import com.example.LoginRegisterEmail.repository.GenericRepository;
import com.example.LoginRegisterEmail.repository.MedicineRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class MedicineService implements Serializable {

    private MedicineRepository medicineRepository;
    private GenericRepository genericRepository;

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


    public void medicineWithGeneric(Long medicineId, GenericMedicineRequest genericMedicineRequest) {
        Medicine medicine = medicineRepository.findById(medicineId)
                .orElseThrow(() -> new IllegalArgumentException("Medicine not found"));
        medicine.setGenericId(genericMedicineRequest.getGenericId());
        medicineRepository.save(medicine);
    }

    public Medicine updateMedicine(Long medicineId, UpdateMedicineRequest updatedMedicine) {
        Medicine existingMedicine = medicineRepository.findById(medicineId)
                .orElseThrow(() -> new MedicineNotFoundException("Medicine not found with id: " + medicineId));

        BeanUtils.copyProperties(updatedMedicine, existingMedicine, getNullPropertyNames(updatedMedicine));

        if (updatedMedicine.getMedicineName() != null) {
            existingMedicine.setMedicineName(updatedMedicine.getMedicineName());
        }

        existingMedicine.setMedicineDescription(updatedMedicine.getMedicineDescription());
        existingMedicine.setMedicinePrice(updatedMedicine.getMedicinePrice());
        existingMedicine.setMedicineQuantity(updatedMedicine.getMedicineQuantity());


        return medicineRepository.save(existingMedicine);
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

}
