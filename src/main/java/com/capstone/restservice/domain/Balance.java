package com.capstone.restservice.domain;

import lombok.Data;

@Data
public class Balance {
    private Long id;
    private Long productId;
    private Long locationId;
    private int quantity;

    public Balance() {}

    public Balance(Long id, Long productId, Long locationId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.locationId = locationId;
        this.quantity = quantity;
    }
}
