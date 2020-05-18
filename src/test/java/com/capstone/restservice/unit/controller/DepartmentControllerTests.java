package com.capstone.restservice.unit.controller;

import com.capstone.restservice.controller.DepartmentController;
import com.capstone.restservice.domain.Department;
import com.capstone.restservice.service.DepartmentService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    @Test
    public void allDepartmentsShouldReturnOkStatusFromService() throws Exception {

        // Arrange

        MvcResult result = this.mockMvc.perform(get("/departments")).
                andDo(print()).andReturn();

        // Assert

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    public void allDepartmentsShouldReturnAllDepartmentsFromService() throws Exception {

        //Arrange

        List<Department> expectedDepartments = new ArrayList<>();
        expectedDepartments.add(new Department(100L,"Shirt"));
        expectedDepartments.add(new Department(200L,"Trousers"));

        when(departmentService.GetAll()).thenReturn(expectedDepartments);

        // Act
        MvcResult result = this.mockMvc.perform(get("/departments")).
                andDo(print()).andReturn();

        // Assert

        verify(departmentService, times(1)).GetAll();

        String response = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Department> actualDepartments = objectMapper.readValue(response, new TypeReference<>() {});
        assertTrue(Arrays.deepEquals(expectedDepartments.toArray(), actualDepartments.toArray()));
    }
}
