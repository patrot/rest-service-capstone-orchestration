package com.capstone.restservice.service;

import com.capstone.restservice.domain.Balance;

import java.util.List;

public interface BalanceService {
    List<Balance> getAll();

    Balance getByProductAndLocation(long productId, long locationId);
}
