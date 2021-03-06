package com.capstone.restservice.unit.restclient;

import com.capstone.restservice.restclient.DepartmentDto;
import com.capstone.restservice.restclient.DepartmentRestClient;
import com.capstone.restservice.restclient.DepartmentRestClientImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class DepartmentRestClientTests {

    @TestConfiguration
    static class DepartmentRestClientImplTestContextConfiguration {

        @Bean
        public DepartmentRestClient departmentRestClient() {
            return new DepartmentRestClientImpl();
        }
    }

    @Autowired
    DepartmentRestClient departmentRestClient;

    @MockBean
    private RestTemplate restTemplate;

    @Before
    public void setup() {

        DepartmentDto[] departmentDtoArray = new DepartmentDto[2];
        departmentDtoArray[0] = new DepartmentDto(1L,"Shirt");
        departmentDtoArray[1] = new DepartmentDto(2L,"Trousers");

        ResponseEntity<DepartmentDto[]> responseEntity = new ResponseEntity<>(departmentDtoArray, new HttpHeaders(), HttpStatus.CREATED);

        Mockito.when(restTemplate.getForEntity(anyString(), any(Class.class)))
                .thenReturn(responseEntity);
    }

    @Test
    public void getAllDepartmentsTest() {

        // Arrange

        List<DepartmentDto> expectedDepartmentDtos = new ArrayList<>();
        expectedDepartmentDtos.add(new DepartmentDto(1L,"Shirt"));
        expectedDepartmentDtos.add(new DepartmentDto(2L,"Trousers"));

        // Act

        List<DepartmentDto> actualDepartmentDtos = departmentRestClient.getAll();

        // Assert

        verify(restTemplate, times(1)).getForEntity(anyString(), any(Class.class));

        assertTrue(Arrays.deepEquals(expectedDepartmentDtos.toArray(), actualDepartmentDtos.toArray()));

    }
}
