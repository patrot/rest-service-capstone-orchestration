package com.capstone.restservice.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRestClientImpl implements ProductRestClient {

    @Value("${product.url}")
    private String productUrl;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<ProductDto> getAll() {
        String allProductsUrl = productUrl + "/products";

        ResponseEntity<ProductDto[]> responseEntity = restTemplate.getForEntity(allProductsUrl, ProductDto[].class);

        ProductDto[] productDtoArray = responseEntity.getBody();

        List<ProductDto>  productDtos = new ArrayList<>(Arrays.asList(productDtoArray));

        return productDtos;
    }

    @Override
    public List<ProductDto> getByDepartment(Long departmentId) {
        String productsByDepartmentUrl = productUrl + "/products?departmentId=" + departmentId;

        ResponseEntity<ProductDto[]> responseEntity = restTemplate.getForEntity(productsByDepartmentUrl, ProductDto[].class);

        ProductDto[] productDtoArray = responseEntity.getBody();

        List<ProductDto>  productDtos = new ArrayList<>(Arrays.asList(productDtoArray));

        return productDtos;
    }
}
