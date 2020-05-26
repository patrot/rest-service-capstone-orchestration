package com.capstone.restservice.controller;

import com.capstone.restservice.domain.Product;
import com.capstone.restservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin
    @GetMapping("/products")
    public List<Product> allProducts(@RequestParam Optional<Long> departmentId) {
        if (departmentId.isEmpty()) {
            return productService.getAll();
        } else {
            return productService.getByDepartment(departmentId.get());
        }
    }
}
