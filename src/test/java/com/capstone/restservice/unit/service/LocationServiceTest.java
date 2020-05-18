package com.capstone.restservice.unit.service;

import com.capstone.restservice.domain.Location;
import com.capstone.restservice.restclient.LocationDto;
import com.capstone.restservice.restclient.LocationRestClient;
import com.capstone.restservice.service.LocationService;
import com.capstone.restservice.service.LocationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

    @MockBean
    private LocationRestClient locationRestClient;

    @Before
    public void setUp() {
        List<LocationDto> locationDtos = new ArrayList<>();
        locationDtos.add(new LocationDto(1L,"Irving", "75016"));
        locationDtos.add(new LocationDto(2L,"Plano", "75025"));

        Mockito.when(locationRestClient.getAll())
                .thenReturn(locationDtos);
    }

    @Test
    public void getAllLocationsTest() {

        // Arrange

        List<Location> expectedLocations = new ArrayList<>();
        expectedLocations.add(new Location(1L,"Irving", "75016"));
        expectedLocations.add(new Location(2L,"Plano", "75025"));

        // Act

        List<Location> actualLocations = locationService.getAll();

        // Assert

        verify(locationRestClient, times(1)).getAll();

        assertTrue(Arrays.deepEquals(expectedLocations.toArray(), actualLocations.toArray()));
    }
}
