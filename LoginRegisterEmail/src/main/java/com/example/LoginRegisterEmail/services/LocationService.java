package com.example.LoginRegisterEmail.services;

import com.example.LoginRegisterEmail.Requests.LocationPharmacyRequest;
import com.example.LoginRegisterEmail.entities.*;
import com.example.LoginRegisterEmail.repository.LocationRepository;
import com.example.LoginRegisterEmail.repository.PharmacyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@AllArgsConstructor
public class LocationService implements Serializable {

    private LocationRepository locationRepository;
    private PharmacyRepository pharmacyRepository;

    public Location addLocation(Location location) {
            return locationRepository.save(location);
    }

    public void addPharmacyIdLocation(Long locationId, LocationPharmacyRequest locationPharmacyRequest) {

        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new IllegalArgumentException("Location is not found"));

        location.setPharmacyId(locationPharmacyRequest.getLocationId());
        locationRepository.save(location);

    }
}
