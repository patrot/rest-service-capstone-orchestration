package com.capstone.restservice.controller;

import com.capstone.restservice.domain.Balance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BalanceController {
    @GetMapping("/balances")
    public List<Balance> allBalances() {
        List<Balance> balances = new ArrayList<>();
        balances.add(new Balance(1L, 1L, 1L, 10));
        balances.add(new Balance(2L, 1L, 2L, 10));
        balances.add(new Balance(3L, 2L, 1L, 10));
        balances.add(new Balance(4L, 2L, 2L, 10));
        return balances;
    }
}
