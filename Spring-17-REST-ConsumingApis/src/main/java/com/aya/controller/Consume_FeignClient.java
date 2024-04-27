package com.aya.controller;


import com.aya.client.EmployeeClient;
import com.aya.client.UserClient;
import com.aya.dto.ResponseWrapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

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



    @GetMapping("/api/v1/employee")
    public ResponseEntity<ResponseWrapper> getEmployee(){
        return ResponseEntity.ok(new ResponseWrapper("Successfully retrieved ",employeeClient.getEmployee("6298ebfecd0551211fce37a6")));
    }

//    app-id = 6298ebfecd0551211fce37a6

}
