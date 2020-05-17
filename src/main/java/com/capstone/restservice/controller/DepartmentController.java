package com.capstone.restservice.controller;

import com.capstone.restservice.domain.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {

    @GetMapping("/departments")
    public List<Department> allDepartments() {

        List<Department> expectedDepartments = new ArrayList<>();
        expectedDepartments.add(new Department(100L,"Shirt"));
        expectedDepartments.add(new Department(200L,"Trousers"));

        return expectedDepartments;
    }
}
