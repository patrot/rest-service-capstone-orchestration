package com.capstone.restservice.restclient;

import lombok.Data;

@Data
public class LocationDto {
    private Long id;
    private String name;
    private String zipCode;

    public LocationDto() {
        super();
    }

    public LocationDto(Long id, String name, String zipCode) {
        this.id = id;
        this.name = name;
        this.zipCode = zipCode;
    }
}
