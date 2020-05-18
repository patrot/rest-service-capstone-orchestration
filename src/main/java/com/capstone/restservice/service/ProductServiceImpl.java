package com.capstone.restservice.service;

import com.capstone.restservice.domain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> GetAll() {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Long Sleeves", 1L));
        products.add(new Product(2L, "Short Sleeves", 1L));

        return products;
    }
}
