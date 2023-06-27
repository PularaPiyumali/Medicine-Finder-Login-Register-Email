package com.example.LoginRegisterEmail.controllers;

import com.example.LoginRegisterEmail.Requests.UsersRequest;
import com.example.LoginRegisterEmail.entities.Pharmacy;
import com.example.LoginRegisterEmail.services.PharmacyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1")
@AllArgsConstructor
public class PharmacyController {

    private PharmacyService pharmacyService;

    @PostMapping("/pharmacy/add")
    public ResponseEntity<Pharmacy> addPharmacy (@RequestBody Pharmacy pharmacy)
    {
        Pharmacy newPharmacy = pharmacyService.addPharmacy(pharmacy);
        return new ResponseEntity<>(newPharmacy, HttpStatus.CREATED);
    }

    @PutMapping("/{medicineId}/add/{pharmacyId}")
    public ResponseEntity<String> addingMedicine(@PathVariable Long medicineId, @PathVariable Long pharmacyId) {
        try {
            pharmacyService.addingMedicine(medicineId, pharmacyId);
            return ResponseEntity.ok("Pharmacy added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/agent/{pharmacyId}")
    public ResponseEntity<String> addUserPharmacyAgent(@PathVariable Long pharmacyId, @RequestBody UsersRequest usersRequest) {
        try {
            pharmacyService.addUserPharmacyAgent(pharmacyId,usersRequest);
            return ResponseEntity.ok("Pharmacy Agent added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
