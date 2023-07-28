package com.medifinder.LoginRegisterEmail.controllers;

import com.medifinder.LoginRegisterEmail.Requests.*;
import com.medifinder.LoginRegisterEmail.entities.Generic;
import com.medifinder.LoginRegisterEmail.entities.Medicine;
import com.medifinder.LoginRegisterEmail.repository.MedicineRepository;
import com.medifinder.LoginRegisterEmail.services.GenericService;
import com.medifinder.LoginRegisterEmail.services.MedicineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1")
@CrossOrigin
@AllArgsConstructor
public class MedicineController {

    private MedicineService medicineService;
    private GenericService genericService;
    private MedicineRepository medicineRepository;

    @PostMapping("/medicines")
    public ResponseEntity<Medicine> addMedicine(@RequestBody MedicineRequest medicineRequest)
    {
        Medicine newMedicine = medicineService.addMedicine(medicineRequest);
        return new ResponseEntity<>(newMedicine, HttpStatus.CREATED);
    }

    @PostMapping("/generics")
    public ResponseEntity<Generic> addGeneric(@RequestBody GenericRequest genericRequest)
    {
        Generic newGeneric = genericService.addGeneric(genericRequest);
        return new ResponseEntity<>(newGeneric, HttpStatus.CREATED);
    }

    @GetMapping("/medicines")
    public ResponseEntity <Medicine> searchMedicine (@RequestBody MedicineRequest medicineRequest){
        Medicine medicine= medicineService.findMedicineName(medicineRequest);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    @PutMapping("/medicines/{medicineId}")
    public ResponseEntity <Medicine> updateMedicine (@PathVariable Long medicineId, @RequestBody Medicine updatedMedicine){
        Medicine updated = medicineService.updateMedicine(medicineId, updatedMedicine);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping ("/medicines/{medicineId}")
    public ResponseEntity <?> deleteMedicine (@PathVariable("medicineId") Long medicineId){
        medicineService.deleteMedicine(medicineId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/generics/{medicineId}")
    public ResponseEntity<String> medicineWithGeneric(@PathVariable Long medicineId, @RequestBody GenericMedicineRequest genericMedicineRequest) {
        try {
            medicineService.medicineWithGeneric(medicineId, genericMedicineRequest);
            return ResponseEntity.ok("Generic type  added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("medicines/all")
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    @PutMapping("pharmacies/{medicineId}")
    public ResponseEntity<String> addPharmacyMedicine(@PathVariable Long medicineId, @RequestBody PharmacyIdRequest pharmacyIdRequest) {
        try {
            medicineService.addPharmacyMedicine(medicineId,pharmacyIdRequest);
            return ResponseEntity.ok("Pharmacy Id added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
