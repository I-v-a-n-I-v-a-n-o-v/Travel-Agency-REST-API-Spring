package com.uni.pu.fmi.travelagencyrestapi.controller;

import com.uni.pu.fmi.travelagencyrestapi.dto.*;
import com.uni.pu.fmi.travelagencyrestapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseLocationDTO>> getAllLocations() {
        List<ResponseLocationDTO> locations = locationService.getLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseLocationDTO> getLocationById(@PathVariable long id) {
        ResponseLocationDTO location = locationService.getLocationById(id);
        return new ResponseEntity<>(location, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<ResponseLocationDTO> createLocation(@RequestBody CreateLocationDTO createLocationDTO) {
        ResponseLocationDTO responseLocationDTO = locationService.createLocation(createLocationDTO);
        return new ResponseEntity<>(responseLocationDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseLocationDTO> updateLocation(@RequestBody UpdateLocationDTO updateLocationDTO) {
        ResponseLocationDTO responseLocationDTO = locationService.updateLocation(updateLocationDTO);
        return new ResponseEntity<>(responseLocationDTO, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteLocationById(@PathVariable long id) {
        locationService.deleteLocationById(id);
        return ResponseEntity.noContent().build();
    }
}
