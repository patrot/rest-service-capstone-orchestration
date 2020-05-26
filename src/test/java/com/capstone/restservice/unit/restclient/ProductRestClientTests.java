package com.capstone.restservice.unit.restclient;

import com.capstone.restservice.restclient.ProductDto;
import com.capstone.restservice.restclient.ProductRestClient;
import com.capstone.restservice.restclient.ProductRestClientImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class ProductRestClientTests {

    ProductDto[] productDtoArray;

    @TestConfiguration
    static class ProductRestClientImplTestContextConfiguration {

        @Bean
        public ProductRestClient productRestClient() {
            return new ProductRestClientImpl();
        }
    }

    @Value("${product.url}")
    private String productUrl;

    @Autowired
    ProductRestClient productRestClient;

    @MockBean
    private RestTemplate restTemplate;

    @Before
    public void setup() {

        productDtoArray = new ProductDto[2];
        productDtoArray[0] = new ProductDto(1L,"Long Sleeves", 1L);
        productDtoArray[1] = new ProductDto(2L,"Short Sleeves", 1L);

    }

    @Test
    public void getAllProductsTest() {

        // Arrange

        List<ProductDto> expectedProductDtos = new ArrayList<>();
        expectedProductDtos.add(new ProductDto(1L,"Long Sleeves", 1L));
        expectedProductDtos.add(new ProductDto(2L,"Short Sleeves", 1L));

        ResponseEntity<ProductDto[]> responseEntity = new ResponseEntity<>(productDtoArray, new HttpHeaders(), HttpStatus.CREATED);
        Mockito.when(restTemplate.getForEntity(eq(productUrl + "/products"), any(Class.class)))
                .thenReturn(responseEntity);

        // Act

        List<ProductDto> actualProductDtos = productRestClient.getAll();

        // Assert

        verify(restTemplate, times(1)).getForEntity(eq(productUrl + "/products"), any(Class.class));

        assertTrue(Arrays.deepEquals(expectedProductDtos.toArray(), actualProductDtos.toArray()));

    }

    @Test
    public void getByDepartmentTests() {

        // Arrange

        List<ProductDto> expectedProductDtos = new ArrayList<>();
        expectedProductDtos.add(new ProductDto(1L,"Long Sleeves", 1L));

        ProductDto[] subarray = new ProductDto[1];
        subarray[0] = productDtoArray[0];

        Mockito.when(restTemplate.getForEntity(eq(productUrl + "/products?departmentId=1"), any(Class.class)))
                .thenReturn(new ResponseEntity<>(subarray, new HttpHeaders(), HttpStatus.CREATED));

        // Act

        List<ProductDto> actualProductDtos = productRestClient.getByDepartment(1L);

        // Assert

        verify(restTemplate, times(1)).getForEntity(eq(productUrl + "/products?departmentId=1"), any(Class.class));

        assertTrue(Arrays.deepEquals(expectedProductDtos.toArray(), actualProductDtos.toArray()));

    }
}
