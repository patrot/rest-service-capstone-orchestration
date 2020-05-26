package com.capstone.restservice.controller;

import com.capstone.restservice.domain.Balance;
import com.capstone.restservice.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @GetMapping("/balances")
    public List<Balance> allBalances() {

        return balanceService.getAll();
    }

    @GetMapping("/balance")
    public Balance getBalanceByProductAndLocation(
            @RequestParam Long productId,
            @RequestParam Long locationId
    ) {

        return balanceService.getByProductAndLocation(productId, locationId);
    }
}
