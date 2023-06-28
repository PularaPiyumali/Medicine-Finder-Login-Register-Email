package com.example.LoginRegisterEmail.services;

import com.example.LoginRegisterEmail.Requests.LocationPharmacyRequest;
import com.example.LoginRegisterEmail.Requests.LocationRequest;
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

    public Location addLocation(LocationRequest locationRequest) {
        Location location = new Location();
        location.setAddress(locationRequest.getAddress());
        location.setCity(locationRequest.getCity());
        location.setLatitude(locationRequest.getLatitude());
        location.setLongitude(locationRequest.getLongitude());
            return locationRepository.save(location);
    }

    public void addPharmacyIdLocation(Long locationId, LocationPharmacyRequest locationPharmacyRequest) {

        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new IllegalArgumentException("Location is not found"));

        location.setPharmacyId(locationPharmacyRequest.getPharmacyId());
        locationRepository.save(location);

    }
}
