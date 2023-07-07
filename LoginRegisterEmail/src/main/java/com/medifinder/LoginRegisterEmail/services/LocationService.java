package com.medifinder.LoginRegisterEmail.services;

import com.medifinder.LoginRegisterEmail.Requests.LocationPharmacyRequest;
import com.medifinder.LoginRegisterEmail.Requests.LocationRequest;

import com.medifinder.LoginRegisterEmail.entities.Location;
import com.medifinder.LoginRegisterEmail.repository.LocationRepository;
import com.medifinder.LoginRegisterEmail.repository.PharmacyRepository;
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
