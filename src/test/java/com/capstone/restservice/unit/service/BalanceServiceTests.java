package com.capstone.restservice.unit.service;

import com.capstone.restservice.domain.Balance;
import com.capstone.restservice.service.BalanceService;
import com.capstone.restservice.service.BalanceServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
public class BalanceServiceTests {

    @TestConfiguration
    static class DepartmentServiceImplTestContextConfiguration {

        @Bean
        public BalanceService balanceService() {
            return new BalanceServiceImpl();
        }
    }

    @Autowired
    BalanceService balanceService;

    @Test
    public void getAllLocationsTest() {

        // Arrange

        List<Balance> expectedProductBalances = new ArrayList<>();
        expectedProductBalances.add(new Balance(1L, 1L, 1L, 10));
        expectedProductBalances.add(new Balance(2L, 1L, 2L, 10));
        expectedProductBalances.add(new Balance(3L, 2L, 1L, 10));
        expectedProductBalances.add(new Balance(4L, 2L, 2L, 10));

        // Act

        List<Balance> actualProductBalances = balanceService.getAll();

        // Assert

        assertTrue(Arrays.deepEquals(expectedProductBalances.toArray(), actualProductBalances.toArray()));
    }
}
