package com.medifinder.LoginRegisterEmail.controllers;

import com.medifinder.LoginRegisterEmail.Requests.LocationPharmacyRequest;
import com.medifinder.LoginRegisterEmail.Requests.LocationRequest;
import com.medifinder.LoginRegisterEmail.entities.Location;
import com.medifinder.LoginRegisterEmail.repository.LocationRepository;
import com.medifinder.LoginRegisterEmail.services.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(path = "api/v1")
public class LocationController {

    private LocationService locationService;
    private LocationRepository locationRepository;

    @PostMapping("/locations")
    public ResponseEntity<Location> addLocation(@RequestBody LocationRequest locationRequest)
    {
        Location newLocation = locationService.addLocation(locationRequest);
        return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
    }

    @PutMapping("/locations/{locationId}")
    public ResponseEntity<String> addPharmacyIdLocation (@PathVariable Long locationId , @RequestBody LocationPharmacyRequest locationPharmacyRequest) {
        try {
            locationService.addPharmacyIdLocation(locationId,locationPharmacyRequest);
            return ResponseEntity.ok("Pharmacy Added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("locations/all")
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
