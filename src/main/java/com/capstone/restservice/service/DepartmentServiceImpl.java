package com.capstone.restservice.service;

import com.capstone.restservice.domain.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public List<Department> GetAll() {

        List<Department> expectedDepartments = new ArrayList<>();
        expectedDepartments.add(new Department(100L,"Shirt"));
        expectedDepartments.add(new Department(200L,"Trousers"));

        return expectedDepartments;
    }
}
