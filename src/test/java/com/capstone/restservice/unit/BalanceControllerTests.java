package com.capstone.restservice.unit;

import com.capstone.restservice.controller.BalanceController;
import com.capstone.restservice.domain.Balance;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(BalanceController.class)
public class BalanceControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void allBalancesShouldReturnOkStatusFromService() throws Exception {

        //Arrange

        // Act

        MvcResult result = this.mockMvc.perform(get("/balances")).
                andDo(print()).andReturn();

        // Assert

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void allBalancesShouldReturnAllBalancesFromService() throws Exception {

        // Arrange

        List<Balance> expectedProductBalances = new ArrayList<>();
        expectedProductBalances.add(new Balance(1L, 1L, 1L, 10));
        expectedProductBalances.add(new Balance(2L, 1L, 2L, 10));
        expectedProductBalances.add(new Balance(3L, 2L, 1L, 10));
        expectedProductBalances.add(new Balance(4L, 2L, 2L, 10));

        // Act

        MvcResult result = this.mockMvc.perform(get("/balances")).
                andDo(print()).andReturn();

        // Assert

        String response = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Balance> actualProductBalances = objectMapper.readValue(response, new TypeReference<>() {});
        assertTrue(Arrays.deepEquals(expectedProductBalances.toArray(), actualProductBalances.toArray()));
    }
}
