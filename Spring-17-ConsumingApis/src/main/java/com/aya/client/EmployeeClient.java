package com.aya.client;


import com.aya.dto.Employee;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(url = "https://dummyapi.io",name = "EMPLOYEE-CLIENT")
public interface EmployeeClient {

    @GetMapping("/data/v1/user")
    Employee getEmployee(@RequestHeader("app-id") String id);

}
