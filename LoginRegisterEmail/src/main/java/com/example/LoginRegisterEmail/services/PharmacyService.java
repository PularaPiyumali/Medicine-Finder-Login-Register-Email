package com.example.LoginRegisterEmail.services;

import com.example.LoginRegisterEmail.Requests.PharmacyRequest;
import com.example.LoginRegisterEmail.Requests.UsersRequest;
import com.example.LoginRegisterEmail.entities.Generic;
import com.example.LoginRegisterEmail.entities.Medicine;
import com.example.LoginRegisterEmail.entities.Pharmacy;
import com.example.LoginRegisterEmail.entities.User;
import com.example.LoginRegisterEmail.repository.MedicineRepository;
import com.example.LoginRegisterEmail.repository.PharmacyRepository;
import com.example.LoginRegisterEmail.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Set;

@Service
@AllArgsConstructor
public class PharmacyService implements Serializable {

    private PharmacyRepository pharmacyRepository;
    private MedicineRepository medicineRepository;
    private UserRepository userRepository;

    public Pharmacy addPharmacy(PharmacyRequest pharmacyRequest) {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setPharmacyName(pharmacyRequest.getPharmacyName());
        return pharmacyRepository.save(pharmacy);
    }


    public Pharmacy addingMedicine (Long medicineId, Long pharmacyId) {
        Set<Medicine> medicineSet = null;
        Medicine medicine = medicineRepository.findById(medicineId).get();
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId).get();
        medicineSet =  pharmacy.getAddingMedicine();
        medicineSet.add(medicine);
        pharmacy.setAddingMedicine(medicineSet);
        return pharmacyRepository.save(pharmacy);
    }

    public void addUserPharmacyAgent(Long pharmacyId, UsersRequest usersRequest) {

        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId)
                .orElseThrow(() -> new IllegalArgumentException("Id not found"));
        pharmacy.setUserId(usersRequest.getUserId());
        pharmacyRepository.save(pharmacy);
    }

}
