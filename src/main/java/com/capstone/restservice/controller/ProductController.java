package com.capstone.restservice.controller;

import com.capstone.restservice.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> allProducts() {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Long Sleeves", 7L));
        products.add(new Product(2L, "Short Sleeves", 7L));

        return products;
    }
}
