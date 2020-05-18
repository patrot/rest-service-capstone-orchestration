package com.capstone.restservice.service;

import com.capstone.restservice.domain.Department;
import com.capstone.restservice.restclient.DepartmentDto;
import com.capstone.restservice.restclient.DepartmentRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRestClient departmentRestClient;

    @Override
    public List<Department> getAll() {

        List<DepartmentDto> departmentDtos = departmentRestClient.getAll();

        List<Department> departments = new ArrayList<>();

        for (DepartmentDto departmentDto:departmentDtos) {
            departments.add(new Department(departmentDto.getId(), departmentDto.getName()));
        }

        return departments;
    }
}
