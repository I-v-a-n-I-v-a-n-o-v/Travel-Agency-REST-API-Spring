package com.uni.pu.fmi.travelagencyrestapi.service;

import com.uni.pu.fmi.travelagencyrestapi.dto.*;
import com.uni.pu.fmi.travelagencyrestapi.entity.Holiday;
import com.uni.pu.fmi.travelagencyrestapi.entity.Location;
import com.uni.pu.fmi.travelagencyrestapi.mapper.LocationMapper;
import com.uni.pu.fmi.travelagencyrestapi.repository.LocationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Autowired
    private LocationService(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    public List<ResponseLocationDTO> getLocations() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream().map(locationMapper::locationToResponseLocationDTO).toList();
    }

    public ResponseLocationDTO getLocationById(long id) {
        Location location = locationRepository.getReferenceById(id);

        return locationMapper.locationToResponseLocationDTO(location);
    }

    public ResponseLocationDTO createLocation(CreateLocationDTO createLocationDTO) {
        Location location = new Location();
        location.setCity(createLocationDTO.getCity());
        location.setStreet(createLocationDTO.getStreet());
        location.setNumber(createLocationDTO.getNumber());
        location.setCountry(createLocationDTO.getCountry());
        location.setImageUrl(createLocationDTO.getImageUrl());
        locationRepository
                .save(location);
        return locationMapper.locationToResponseLocationDTO(location);
    }

    public ResponseLocationDTO updateLocation(UpdateLocationDTO updateLocationDTO) {
        Location location = locationRepository.findById(updateLocationDTO.getId()).orElseThrow();
        location.setNumber(updateLocationDTO.getNumber());
        location.setCountry(updateLocationDTO.getCountry());
        location.setImageUrl(updateLocationDTO.getImageUrl());
        location.setStreet(updateLocationDTO.getStreet());
        location.setCity(updateLocationDTO.getCity());

        locationRepository
                .save(location);
        return locationMapper.locationToResponseLocationDTO(location);
    }
    public void deleteLocationById(long id) {
        locationRepository.deleteById(id);
    }
}
