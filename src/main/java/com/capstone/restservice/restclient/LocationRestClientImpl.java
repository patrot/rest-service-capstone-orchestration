package com.capstone.restservice.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LocationRestClientImpl implements LocationRestClient {

    @Value("${location.url}")
    private String locationUrl;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public List<LocationDto> getAll() {

        String allLocationsUrl = locationUrl + "/locations";

        WebClient webClient = webClientBuilder.baseUrl(locationUrl).build();

        WebClient.RequestHeadersSpec<?> requestSpec = webClient.get().uri("/locations");

        LocationDto[] locationDtoArray = requestSpec.exchange()
                .block()
                .bodyToMono(LocationDto[].class)
                .block();

        List<LocationDto> locationDtos = new ArrayList<>(Arrays.asList(locationDtoArray));

        return locationDtos;
    }
}
