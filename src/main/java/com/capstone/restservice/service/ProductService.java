package com.capstone.restservice.service;

import com.capstone.restservice.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    List<Product> getByDepartment(Long departmentId);
}
