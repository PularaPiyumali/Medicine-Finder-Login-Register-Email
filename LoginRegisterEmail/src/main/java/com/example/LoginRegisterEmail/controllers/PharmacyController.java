package com.example.LoginRegisterEmail.controllers;

import com.example.LoginRegisterEmail.entities.Pharmacy;
import com.example.LoginRegisterEmail.services.PharmacyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
