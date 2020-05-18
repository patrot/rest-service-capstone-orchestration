package com.capstone.restservice.restclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LocationRestClientImpl implements LocationRestClient {

    private final String locationUrl = "http://ec2-35-172-117-48.compute-1.amazonaws.com:8080";

    @Override
    public List<LocationDto> getAll() {

        String allLocationsUrl = locationUrl + "/locations";

        WebClient webClient = WebClient.create(allLocationsUrl);

        WebClient.RequestHeadersSpec<?> requestSpec = webClient.get();

        LocationDto[] locationDtoArray = requestSpec.exchange()
                .block()
                .bodyToMono(LocationDto[].class)
                .block();

        List<LocationDto> locationDtos = new ArrayList<>(Arrays.asList(locationDtoArray));

        return locationDtos;
    }
}
