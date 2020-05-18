package com.capstone.restservice.service;

import com.capstone.restservice.domain.Location;
import com.capstone.restservice.restclient.LocationDto;
import com.capstone.restservice.restclient.LocationRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationRestClient locationRestClient;

    @Override
    public List<Location> getAll() {
        List<LocationDto> locationDtos = locationRestClient.getAll();

        List<Location> locations = new ArrayList<>();

        for (LocationDto locationDto:locationDtos) {
            locations.add(new Location(locationDto.getId(), locationDto.getName(), locationDto.getZipCode()));
        }

        return locations;
    }
}
