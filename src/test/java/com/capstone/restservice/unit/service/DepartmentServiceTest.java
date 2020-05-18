package com.capstone.restservice.unit.service;

import com.capstone.restservice.domain.Department;
import com.capstone.restservice.service.DepartmentService;
import com.capstone.restservice.service.DepartmentServiceImpl;
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
public class DepartmentServiceTest {

    @TestConfiguration
    static class DepartmentServiceImplTestContextConfiguration {

        @Bean
        public DepartmentService departmentService() {
            return new DepartmentServiceImpl();
        }
    }

    @Autowired
    DepartmentService departmentService;

    @Test
    public void getAllDepartmentsTest() {

        //Arrange

        List<Department> expectedDepartments = new ArrayList<>();
        expectedDepartments.add(new Department(100L,"Shirt"));
        expectedDepartments.add(new Department(200L,"Trousers"));

        // Act

        List<Department> actualDepartments = departmentService.GetAll();

        // Assert

        assertTrue(Arrays.deepEquals(expectedDepartments.toArray(), actualDepartments.toArray()));
    }
}
