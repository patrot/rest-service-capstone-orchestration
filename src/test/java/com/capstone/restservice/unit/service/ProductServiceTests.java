package com.capstone.restservice.unit.service;

import com.capstone.restservice.domain.Product;
import com.capstone.restservice.service.ProductService;
import com.capstone.restservice.service.ProductServiceImpl;
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
public class ProductServiceTests {

    @TestConfiguration
    static class ProductServiceImplTestContextConfiguration {

        @Bean
        public ProductService productService() {
            return new ProductServiceImpl();
        }
    }

    @Autowired
    ProductService productService;

    @Test
    public void getAllProductsTest() {

        // Arrange

        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product(1l, "Long Sleeves", 1L));
        expectedProducts.add(new Product(2l, "Short Sleeves", 1L));

        // Act

        List<Product> actualProducts = productService.GetAll();

        // Assert

        assertTrue(Arrays.deepEquals(expectedProducts.toArray(), actualProducts.toArray()));
    }
}
