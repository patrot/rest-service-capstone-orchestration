package com.capstone.restservice.restclient;

import java.util.List;

public interface ProductRestClient {
    List<ProductDto> getAll();
    List<ProductDto> getByDepartment(Long departmentId);
}
