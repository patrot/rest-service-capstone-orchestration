package com.capstone.restservice.domain;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private Long departmentId;

    public Product() {
        super();
    }

    public Product(Long id, String name, Long departmentId) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
    }
}
