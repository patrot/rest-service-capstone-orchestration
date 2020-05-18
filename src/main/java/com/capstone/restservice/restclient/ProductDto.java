package com.capstone.restservice.restclient;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable {
    private Long id;
    private String name;
    private Long departmentId;

    public ProductDto() {
        super();
    }

    public ProductDto(Long id, String name, Long departmentId) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
    }
}
