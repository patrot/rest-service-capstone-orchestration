package com.capstone.restservice.service;

import com.capstone.restservice.domain.Balance;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {
    @Override
    public List<Balance> getAll() {
        List<Balance> balances = new ArrayList<>();
        balances.add(new Balance(1L, 1L, 1L, 10));
        balances.add(new Balance(2L, 1L, 2L, 10));
        balances.add(new Balance(3L, 2L, 1L, 10));
        balances.add(new Balance(4L, 2L, 2L, 10));
        return balances;
    }
}
