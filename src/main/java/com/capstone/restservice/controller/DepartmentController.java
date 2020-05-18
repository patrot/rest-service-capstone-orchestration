package com.capstone.restservice.controller;

import com.capstone.restservice.domain.Department;
import com.capstone.restservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> allDepartments() {

        return departmentService.GetAll();
    }
}
