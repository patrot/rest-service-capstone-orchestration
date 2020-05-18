package com.capstone.restservice.restclient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentRestClientImpl implements DepartmentRestClient {

    private final String departmentUrl = "http://ec2-3-89-224-158.compute-1.amazonaws.com:8080/";


    @Override
    public List<DepartmentDto> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        String allDepartmentsUrl = departmentUrl + "/departments";

        ResponseEntity<DepartmentDto[]> responseEntity = restTemplate.getForEntity(allDepartmentsUrl, DepartmentDto[].class);

        DepartmentDto[] departmentDtoArray = responseEntity.getBody();

        List<DepartmentDto> departmentDtos = new ArrayList<>();

        for (DepartmentDto departmentDto:departmentDtoArray) {
            departmentDtos.add(departmentDto);
        }

        return departmentDtos;
    }
}
