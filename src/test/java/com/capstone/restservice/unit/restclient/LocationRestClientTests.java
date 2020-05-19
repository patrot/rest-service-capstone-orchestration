package com.capstone.restservice.unit.restclient;

import com.capstone.restservice.restclient.LocationDto;
import com.capstone.restservice.restclient.LocationRestClient;
import com.capstone.restservice.restclient.LocationRestClientImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class LocationRestClientTests {

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

    @Mock
    private WebClient.Builder builderMock;

    @Mock
    private WebClient webClientMock;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersMock;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriMock;

    @Mock
    private WebClient.RequestBodySpec requestBodyMock;

    @Mock
    private WebClient.RequestBodyUriSpec requestBodyUriMock;

    @Mock
    private WebClient.ResponseSpec responseMock;

    @Before
    public void setup() {
        when(webClientBuilder.baseUrl(anyString())).thenReturn(builderMock);
        when(builderMock.build()).thenReturn(webClientMock);
    }

    @Test
    public void getAllLocationsTest() {

        // Arrange

        LocationDto[] expectedLocationDtoArray = new LocationDto[2];
        expectedLocationDtoArray[0] = new LocationDto(1L,"Irving", "75016");
        expectedLocationDtoArray[1] = new LocationDto(2L,"Plano", "75025");


        when(webClientMock.get()).thenReturn(requestHeadersUriMock);
        when(requestHeadersUriMock.uri("/locations")).thenReturn(requestHeadersMock);
        when(requestHeadersMock.retrieve()).thenReturn(responseMock);
        when(responseMock.bodyToMono(LocationDto[].class)).thenReturn(Mono.just(expectedLocationDtoArray));

        // Act

        List<LocationDto> actualLocationDtos = locationRestClient.getAll();

        // Assert

        assertTrue(Arrays.deepEquals(expectedLocationDtoArray, actualLocationDtos.toArray()));
    }
}
