package com.capstone.restservice;

import com.capstone.restservice.controller.BalanceController;
import com.capstone.restservice.controller.DepartmentController;
import com.capstone.restservice.controller.LocationController;
import com.capstone.restservice.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private DepartmentController departmentController;

    @Autowired
    private ProductController productController;

    @Autowired
    private LocationController locationController;

    @Autowired
    private BalanceController balanceController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(departmentController).isNotNull();
        assertThat(productController).isNotNull();
        assertThat(locationController).isNotNull();
        assertThat(balanceController).isNotNull();
    }
}
