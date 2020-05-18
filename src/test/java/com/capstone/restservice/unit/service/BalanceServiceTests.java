package com.capstone.restservice.unit.service;

import com.capstone.restservice.domain.Balance;
import com.capstone.restservice.restclient.BalanceDto;
import com.capstone.restservice.restclient.BalanceRestClient;
import com.capstone.restservice.service.BalanceService;
import com.capstone.restservice.service.BalanceServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

    @MockBean
    private BalanceRestClient balanceRestClient;

    @Before
    public void setUp() {
        List<BalanceDto> balanceDtos = new ArrayList<>();
        balanceDtos.add(new BalanceDto(1L,1L, 1L, 10));
        balanceDtos.add(new BalanceDto(2L,1L, 2L, 10));
        balanceDtos.add(new BalanceDto(3L,2L, 1L, 10));
        balanceDtos.add(new BalanceDto(4L,2L, 2L, 10));

        Mockito.when(balanceRestClient.getAll())
                .thenReturn(balanceDtos);
    }

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

        verify(balanceRestClient, times(1)).getAll();

        assertTrue(Arrays.deepEquals(expectedProductBalances.toArray(), actualProductBalances.toArray()));
    }
}
