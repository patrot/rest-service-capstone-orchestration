package com.capstone.restservice.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "productbalances", url = "${balance.url}", configuration = BalanceRestClientConfiguration.class)
public interface BalanceRestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/productbalances")
    List<BalanceDto> getAll();

    @RequestMapping(method = RequestMethod.GET, value = "/balance")
    BalanceDto getByProductAndLocation(
            @RequestParam(value="productId") Long productId,
            @RequestParam(value="locationId") Long locationId);
}
