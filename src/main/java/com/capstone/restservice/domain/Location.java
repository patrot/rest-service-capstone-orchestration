package com.capstone.restservice.domain;

import lombok.Data;

@Data
public class Location {
    private Long id;
    private String name;
    private String zipCode;

    public Location() {
        super();
    }

    public Location(Long id, String name, String zipCode) {
        this.id = id;
        this.name = name;
        this.zipCode = zipCode;
    }
}
