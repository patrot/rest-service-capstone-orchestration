package com.capstone.restservice.service;

import com.capstone.restservice.domain.Location;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{
    @Override
    public List<Location> getAll() {

        List<Location> locations = new ArrayList<>();
        locations.add(new Location(1L,"Irving", "75016"));
        locations.add(new Location(2L,"Plano", "75025"));
        return locations;
    }
}
