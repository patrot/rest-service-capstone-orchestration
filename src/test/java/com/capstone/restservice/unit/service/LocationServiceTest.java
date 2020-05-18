package com.capstone.restservice.unit.service;

import com.capstone.restservice.domain.Location;
import com.capstone.restservice.service.LocationService;
import com.capstone.restservice.service.LocationServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
public class LocationServiceTest {

    @TestConfiguration
    static class DepartmentServiceImplTestContextConfiguration {

        @Bean
        public LocationService departmentService() {
            return new LocationServiceImpl();
        }
    }

    @Autowired
    LocationService locationService;

    @Test
    public void getAllLocationsTest() {

        // Arrange

        List<Location> expectedLocations = new ArrayList<>();
        expectedLocations.add(new Location(1L,"Irving", "75016"));
        expectedLocations.add(new Location(2L,"Plano", "75025"));

        // Act

        List<Location> actualLocations = locationService.getAll();

        // Assert

        assertTrue(Arrays.deepEquals(expectedLocations.toArray(), actualLocations.toArray()));
    }
}
