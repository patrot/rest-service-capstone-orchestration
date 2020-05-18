package com.capstone.restservice.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "productbalances", url = "http://ec2-184-73-73-204.compute-1.amazonaws.com:8080/", configuration = BalanceRestClientConfiguration.class)
public interface BalanceRestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/productbalances")
    List<BalanceDto> getAll();
}
