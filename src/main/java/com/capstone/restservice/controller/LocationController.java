package com.capstone.restservice.controller;

import com.capstone.restservice.domain.Location;
import com.capstone.restservice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @CrossOrigin
    @GetMapping("/locations")
    public List<Location> allLocations() {
        return locationService.getAll();
    }
}
