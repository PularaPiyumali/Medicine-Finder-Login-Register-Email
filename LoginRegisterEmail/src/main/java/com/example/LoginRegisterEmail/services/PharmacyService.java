package com.example.LoginRegisterEmail.services;

import com.example.LoginRegisterEmail.entities.Medicine;
import com.example.LoginRegisterEmail.entities.Pharmacy;
import com.example.LoginRegisterEmail.repoistory.PharmacyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@AllArgsConstructor
public class PharmacyService implements Serializable {

    private PharmacyRepository pharmacyRepository;
    public Pharmacy addPharmacy(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }
}
