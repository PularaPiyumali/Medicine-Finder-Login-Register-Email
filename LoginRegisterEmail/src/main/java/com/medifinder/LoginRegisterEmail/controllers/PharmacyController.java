package com.medifinder.LoginRegisterEmail.controllers;

import com.medifinder.LoginRegisterEmail.Requests.PharmacyRequest;
import com.medifinder.LoginRegisterEmail.Requests.UsersIdRequest;
import com.medifinder.LoginRegisterEmail.entities.Medicine;
import com.medifinder.LoginRegisterEmail.entities.Pharmacy;
import com.medifinder.LoginRegisterEmail.repository.PharmacyRepository;
import com.medifinder.LoginRegisterEmail.services.PharmacyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
@AllArgsConstructor
public class PharmacyController {

    private PharmacyService pharmacyService;
    private PharmacyRepository pharmacyRepository;

    @PostMapping("/pharmacies")
    public ResponseEntity<Pharmacy> addPharmacy (@RequestBody PharmacyRequest pharmacyRequest)
    {
        Pharmacy newPharmacy = pharmacyService.addPharmacy(pharmacyRequest);
        return new ResponseEntity<>(newPharmacy, HttpStatus.CREATED);
    }

    @PutMapping("/{medicineId}/pharmacies/{pharmacyId}")
    public ResponseEntity<String> addingMedicine(@PathVariable Long medicineId, @PathVariable Long pharmacyId) {
        try {
            pharmacyService.addingMedicine(medicineId, pharmacyId);
            return ResponseEntity.ok("Pharmacy added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/agents/{pharmacyId}")
    public ResponseEntity<String> addUserPharmacyAgent(@PathVariable Long pharmacyId, @RequestBody UsersIdRequest usersRequest) {
        try {
            pharmacyService.addUserPharmacyAgent(pharmacyId,usersRequest);
            return ResponseEntity.ok("Pharmacy Agent added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("pharmacies/all")
    public List<Pharmacy> getPharmacies() {
        return pharmacyRepository.findAll();
    }
}
