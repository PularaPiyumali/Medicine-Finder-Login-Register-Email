package com.example.LoginRegisterEmail.controllers;

import com.example.LoginRegisterEmail.Requests.GenericMedicineRequest;
import com.example.LoginRegisterEmail.Requests.UpdateMedicineRequest;
import com.example.LoginRegisterEmail.entities.Generic;
import com.example.LoginRegisterEmail.entities.Medicine;
import com.example.LoginRegisterEmail.entities.Pharmacy;
import com.example.LoginRegisterEmail.exceptions.MedicineNotFoundException;
import com.example.LoginRegisterEmail.repository.MedicineRepository;
import com.example.LoginRegisterEmail.services.GenericService;
import com.example.LoginRegisterEmail.services.MedicineService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping(path = "api/v1")
@CrossOrigin
@AllArgsConstructor
public class MedicineController {

    private MedicineService medicineService;
    private GenericService genericService;
    private MedicineRepository medicineRepository;

    @PostMapping("/medicine/add")
    public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine)
    {
        Medicine newMedicine = medicineService.addMedicine(medicine);
        return new ResponseEntity<>(newMedicine, HttpStatus.CREATED);
    }

    @PostMapping("/generic/add")
    public ResponseEntity<Generic> addGeneric(@RequestBody Generic generic)
    {
        Generic newGeneric = genericService.addGeneric(generic);
        return new ResponseEntity<>(newGeneric, HttpStatus.CREATED);
    }

    @GetMapping("/medicine/find/{medicineName}")
    public ResponseEntity <Medicine> searchMedicine (@PathVariable("medicineName") String medicineName){
        Medicine medicine= medicineService.findMedicineName(medicineName);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    @PutMapping("/medicine/update/{medicineId}")
    public ResponseEntity <Medicine> updateMedicine (@PathVariable Long medicineId, @RequestBody UpdateMedicineRequest updatedMedicine){
        Medicine updated = medicineService.updateMedicine(medicineId, updatedMedicine);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping ("/medicine/delete/{medicineId}")
    public ResponseEntity <?> deleteMedicine (@PathVariable("medicineId") Long medicineId){
        medicineService.deleteMedicine(medicineId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/generic/{medicineId}")
    public ResponseEntity<String> medicineWithGeneric(@PathVariable Long medicineId, @RequestBody GenericMedicineRequest genericMedicineRequest) {
        try {
            medicineService.medicineWithGeneric(medicineId, genericMedicineRequest);
            return ResponseEntity.ok("Generic type  added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("medicine/all")
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }
}
