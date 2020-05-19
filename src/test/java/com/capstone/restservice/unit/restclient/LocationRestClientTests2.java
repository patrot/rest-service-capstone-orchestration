package com.capstone.restservice.unit.restclient;

import com.capstone.restservice.restclient.LocationDto;
import com.capstone.restservice.restclient.LocationRestClient;
import com.capstone.restservice.restclient.LocationRestClientImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class LocationRestClientTests2 {

    @TestConfiguration
    static class LocationRestClientImplTestContextConfiguration {

        @Bean
        public LocationRestClient locationRestClient() {
            return new LocationRestClientImpl();
        }
    }

    @Autowired
    LocationRestClient locationRestClient;

    @MockBean
    private WebClient.Builder webClientBuilder;

    @Before
    public void setup() {
    }

    @Test
    public void getAllLocationsTest() {

        // Arrange

        LocationDto[] expectedLocationDtoArray = new LocationDto[2];
        expectedLocationDtoArray[0] = new LocationDto(1L,"Irving", "75016");
        expectedLocationDtoArray[1] = new LocationDto(2L,"Plano", "75025");

        WebClient.Builder builderMock = new MockLocationWebClientBuilder()
                .setUriPath("/locations")
                .setHttpGetBody(expectedLocationDtoArray).build();

        System.out.println(builderMock);

        when(webClientBuilder.baseUrl(anyString())).thenReturn(builderMock);

        // Act

        List<LocationDto> actualLocationDtos = locationRestClient.getAll();

        // Assert

        assertTrue(Arrays.deepEquals(expectedLocationDtoArray, actualLocationDtos.toArray()));
    }
}
