package com.example.LoginRegisterEmail.controllers;

import com.example.LoginRegisterEmail.entities.Generic;
import com.example.LoginRegisterEmail.entities.Medicine;
import com.example.LoginRegisterEmail.services.GenericService;
import com.example.LoginRegisterEmail.services.MedicineService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1")
@AllArgsConstructor
public class MedicineController {

    private MedicineService medicineService;
    private GenericService genericService;

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

    @PutMapping("/medicine/update")
    public ResponseEntity <Medicine> updateMedicine (@RequestBody Medicine medicine){
        Medicine updateMedicine = medicineService.addMedicine(medicine);
        return new ResponseEntity<>(updateMedicine, HttpStatus.CREATED);
    }

    @DeleteMapping ("/medicine/delete/{medicineId}")
    public ResponseEntity <?> deleteMedicine (@PathVariable("medicineId") Long medicineId){
        medicineService.deleteMedicine(medicineId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
