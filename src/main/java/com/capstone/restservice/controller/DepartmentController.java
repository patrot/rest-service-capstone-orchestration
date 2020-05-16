package com.capstone.restservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @GetMapping("/departments")
    public List<Object> allDepartments() {
        return null;
    }
}
