package com.capstone.restservice.service;

import com.capstone.restservice.domain.Balance;
import com.capstone.restservice.restclient.BalanceDto;
import com.capstone.restservice.restclient.BalanceRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceRestClient balanceRestClient;

    @Override
    public List<Balance> getAll() {
        List<BalanceDto> balanceDtos = balanceRestClient.getAll();

        List<Balance> balances = new ArrayList<>();

        for (BalanceDto balanceDto:balanceDtos) {
            balances.add(new Balance(
                    balanceDto.getId(), balanceDto.getProductId(), balanceDto.getLocationId(), balanceDto.getQuantity()));
        }

        return balances;
    }
}
