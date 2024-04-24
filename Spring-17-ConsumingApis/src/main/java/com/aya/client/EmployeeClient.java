package com.aya.client;


import com.aya.dto.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(url = "https://dummyapi.io", name = "TEST-EMPLOYEE")
public interface EmployeeClient {


//    https://dummyapi.io/data/v1/user?limit=10


    @GetMapping("/data/v1/user")
    List<Employee> getEmployee(@RequestHeader("app-id")String id);

}
