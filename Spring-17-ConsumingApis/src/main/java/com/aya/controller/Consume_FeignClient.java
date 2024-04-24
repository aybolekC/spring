package com.aya.controller;


import com.aya.client.EmployeeClient;
import com.aya.client.UserClient;
import com.aya.dto.ResponseWrapper;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consume_FeignClient {


    private final UserClient userClient;
    private final EmployeeClient employeeClient;


    public Consume_FeignClient(UserClient userClient, EmployeeClient employeeClient) {
        this.userClient = userClient;
        this.employeeClient = employeeClient;
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<ResponseWrapper> getUsers(){

        return ResponseEntity.ok(new ResponseWrapper("test", userClient.getUsers()));
    }


    @GetMapping("/api/v1/empoyee")
    public ResponseEntity<ResponseWrapper> getEmployees(){
        return ResponseEntity.ok(new ResponseWrapper("test2", employeeClient.getEmployee("6298ebfecd0551211fce37a6")));
    }



}
