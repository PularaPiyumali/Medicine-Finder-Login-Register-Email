package com.medifinder.LoginRegisterEmail.services;

import com.medifinder.LoginRegisterEmail.Requests.PharmacyRequest;
import com.medifinder.LoginRegisterEmail.Requests.UsersIdRequest;
import com.medifinder.LoginRegisterEmail.entities.Medicine;
import com.medifinder.LoginRegisterEmail.entities.Pharmacy;
import com.medifinder.LoginRegisterEmail.repository.MedicineRepository;
import com.medifinder.LoginRegisterEmail.repository.PharmacyRepository;
import com.medifinder.LoginRegisterEmail.repository.UserRepository;
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


    public void addingMedicine (Long medicineId, Long pharmacyId) {
        Set<Medicine> medicineSet = null;
        Medicine medicine = medicineRepository.findById(medicineId).get();
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId).get();
        medicineSet =  pharmacy.getAddingMedicine();
        medicineSet.add(medicine);
        pharmacy.setAddingMedicine(medicineSet);
        pharmacyRepository.save(pharmacy);
    }

    public void addUserPharmacyAgent(Long pharmacyId, UsersIdRequest usersRequest) {

        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId)
                .orElseThrow(() -> new IllegalArgumentException("Id not found"));
        pharmacy.setUserId(usersRequest.getUserId());
        pharmacyRepository.save(pharmacy);
    }

}
