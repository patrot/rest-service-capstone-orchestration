package com.capstone.restservice.restclient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRestClientImpl implements ProductRestClient {

    private final String productUrl = "http://ec2-3-89-224-158.compute-1.amazonaws.com:8080/";

    @Override
    public List<ProductDto> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        String allProductsUrl = productUrl + "/products";

        ResponseEntity<ProductDto[]> responseEntity = restTemplate.getForEntity(allProductsUrl, ProductDto[].class);

        ProductDto[] productDtoArray = responseEntity.getBody();

        List<ProductDto>  productDtos = new ArrayList<>(Arrays.asList(productDtoArray));

        return productDtos;
    }
}
