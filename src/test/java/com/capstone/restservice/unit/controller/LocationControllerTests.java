package com.capstone.restservice.unit.controller;

import com.capstone.restservice.controller.LocationController;
import com.capstone.restservice.domain.Location;
import com.capstone.restservice.service.LocationService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(LocationController.class)
public class LocationControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationService locationService;

    @Test
    public void allLocationsShouldReturnOkStatusFromService() throws Exception {

        //Arrange

        // Act

        MvcResult result = this.mockMvc.perform(get("/locations")).
                andDo(print()).andReturn();

        // Assert

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void allLocationsShouldReturnAllLocationsFromService() throws Exception {

        // Arrange

        List<Location> expectedLocations = new ArrayList<>();
        expectedLocations.add(new Location(1L,"Irving", "75016"));
        expectedLocations.add(new Location(2L,"Plano", "75025"));

        when(locationService.getAll()).thenReturn(expectedLocations);

        // Act

        MvcResult result = this.mockMvc.perform(get("/locations")).
                andDo(print()).andReturn();

        // Assert

        verify(locationService, times(1)).getAll();

        String response = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Location> actualDepartments = objectMapper.readValue(response, new TypeReference<>() {});
        assertTrue(Arrays.deepEquals(expectedLocations.toArray(), actualDepartments.toArray()));
    }
}
