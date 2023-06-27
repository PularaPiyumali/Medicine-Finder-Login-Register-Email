package com.example.LoginRegisterEmail.controllers;

import com.example.LoginRegisterEmail.Requests.LocationPharmacyRequest;
import com.example.LoginRegisterEmail.entities.Location;
import com.example.LoginRegisterEmail.entities.Medicine;
import com.example.LoginRegisterEmail.services.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(path = "api/v1")
public class LocationController {

    private LocationService locationService;

    @PostMapping("/location/add")
    public ResponseEntity<Location> addLocation(@RequestBody Location location)
    {
        Location newLocation = locationService.addLocation(location);
        return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
    }

    @PutMapping("/location/{locationId}")
    public ResponseEntity<String> addPharmacyIdLocation (@PathVariable Long locationId , @RequestBody LocationPharmacyRequest locationPharmacyRequest) {
        try {
            locationService.addPharmacyIdLocation(locationId,locationPharmacyRequest);
            return ResponseEntity.ok("Pharmacy Added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
