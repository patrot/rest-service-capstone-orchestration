package com.capstone.restservice.restclient;

import lombok.Data;

import java.io.Serializable;

@Data
public class DepartmentDto implements Serializable {
    private Long id;
    private String name;

    public DepartmentDto() {
        super();
    }

    public DepartmentDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
