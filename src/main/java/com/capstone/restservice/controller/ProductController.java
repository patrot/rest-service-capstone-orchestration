package com.capstone.restservice.controller;

import com.capstone.restservice.domain.Product;
import com.capstone.restservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> allProducts() {
        return productService.GetAll();
    }
}
