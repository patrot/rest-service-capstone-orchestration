package com.capstone.restservice.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DepartmentRestClientImpl implements DepartmentRestClient {

    @Value("${department.url}")
    private String departmentUrl;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public List<DepartmentDto> getAll() {
        String allDepartmentsUrl = departmentUrl + "/departments";

        ResponseEntity<DepartmentDto[]> responseEntity = restTemplate.getForEntity(allDepartmentsUrl, DepartmentDto[].class);

        DepartmentDto[] departmentDtoArray = responseEntity.getBody();

        List<DepartmentDto> departmentDtos = new ArrayList<>(Arrays.asList(departmentDtoArray));

        return departmentDtos;
    }
}
