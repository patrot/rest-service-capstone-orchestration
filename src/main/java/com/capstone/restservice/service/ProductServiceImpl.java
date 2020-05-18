package com.capstone.restservice.service;

import com.capstone.restservice.domain.Product;
import com.capstone.restservice.restclient.ProductDto;
import com.capstone.restservice.restclient.ProductRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRestClient productRestClient;

    @Override
    public List<Product> getAll() {

        List<ProductDto> productDtos = productRestClient.getAll();

        List<Product> products = new ArrayList<>();
        for (ProductDto productDto:productDtos) {
            products.add(new Product(productDto.getId(), productDto.getName(), productDto.getDepartmentId()));
        }

        return products;
    }
}
