package com.capstone.restservice.controller;

import com.capstone.restservice.domain.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LocationController {
    @GetMapping("/locations")
    public List<Location> allLocations() {

        List<Location> locations = new ArrayList<>();
        locations.add(new Location(1L,"Irving", "75016"));
        locations.add(new Location(2L,"Plano", "75025"));
        return locations;
    }
}
