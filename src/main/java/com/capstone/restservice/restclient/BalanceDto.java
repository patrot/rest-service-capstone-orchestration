package com.capstone.restservice.restclient;

import lombok.Data;

@Data
public class BalanceDto {
    private Long id;
    private Long productId;
    private Long locationId;
    private int quantity;

    public BalanceDto() {}

    public BalanceDto(Long id, Long productId, Long locationId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.locationId = locationId;
        this.quantity = quantity;
    }
}
