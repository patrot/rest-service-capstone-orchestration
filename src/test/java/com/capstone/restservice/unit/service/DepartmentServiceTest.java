package com.capstone.restservice.unit.service;

import com.capstone.restservice.domain.Department;
import com.capstone.restservice.restclient.DepartmentDto;
import com.capstone.restservice.restclient.DepartmentRestClient;
import com.capstone.restservice.service.DepartmentService;
import com.capstone.restservice.service.DepartmentServiceImpl;
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

    @MockBean
    private DepartmentRestClient departmentRestClient;

    @Before
    public void setUp() {
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        departmentDtos.add(new DepartmentDto(1L,"Shirt"));
        departmentDtos.add(new DepartmentDto(2L,"Trousers"));

        Mockito.when(departmentRestClient.getAll())
                .thenReturn(departmentDtos);
    }

    @Test
    public void getAllDepartmentsTest() {

        //Arrange

        List<Department> expectedDepartments = new ArrayList<>();
        expectedDepartments.add(new Department(1L,"Shirt"));
        expectedDepartments.add(new Department(2L,"Trousers"));

        // Act

        List<Department> actualDepartments = departmentService.getAll();

        // Assert

        verify(departmentRestClient, times(1)).getAll();

        assertTrue(Arrays.deepEquals(expectedDepartments.toArray(), actualDepartments.toArray()));
    }
}
