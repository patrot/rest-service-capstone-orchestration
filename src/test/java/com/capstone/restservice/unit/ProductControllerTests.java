package com.capstone.restservice.unit;

import com.capstone.restservice.controller.ProductController;
import com.capstone.restservice.domain.Product;
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

@WebMvcTest(ProductController.class)
public class ProductControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void allProductsShouldReturnOkStatusFromService() throws Exception {

        // Arrange

        MvcResult result = this.mockMvc.perform(get("/products")).
                andDo(print()).andReturn();

        // Assert

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void allProductsShouldReturnAllProductsFromService() throws Exception {

        // Arrange

        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product(1L, "Long Sleeves", 7L));
        expectedProducts.add(new Product(2L, "Short Sleeves", 7L));

        // Act

        MvcResult result = this.mockMvc.perform(get("/products"))
                .andDo(print()).andReturn();

        // Assert

        String response = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> actualProducts = objectMapper.readValue(response, new TypeReference<>() {});
        System.out.println(actualProducts);
        assertTrue(Arrays.deepEquals(expectedProducts.toArray(), actualProducts.toArray()));
    }
}
