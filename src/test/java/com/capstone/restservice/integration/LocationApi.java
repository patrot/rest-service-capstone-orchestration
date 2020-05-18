package com.capstone.restservice.integration;

import com.capstone.restservice.domain.Location;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocationApi {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String locationsPath = "/locations";

    @Test
    @DirtiesContext
    public void locationsPathShouldReturnOkStatus() throws IOException {

        // Arrange
        HttpUriRequest request = new HttpGet("http://localhost:" + port + locationsPath);

        // Act
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Assert
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(200));
    }

    @Test
    @DirtiesContext
    public void locationsPathShouldReturnAllLocationsInPersistence() throws IOException {

        // Arrange

        List<Location> expectedLocations = new ArrayList<>();
        expectedLocations.add(new Location(1L,"Irving", "75016"));
        expectedLocations.add(new Location(2L,"Plano", "75025"));

        HttpUriRequest request = new HttpGet("http://localhost:" + port + locationsPath);

        // Act

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Assert

        String response = EntityUtils.toString(httpResponse.getEntity());
        ObjectMapper objectMapper = new ObjectMapper();
        List<Location> actualLocations = objectMapper.readValue(response, new TypeReference<>() {});
        assertTrue(Arrays.deepEquals(expectedLocations.toArray(), actualLocations.toArray()));
    }
}
