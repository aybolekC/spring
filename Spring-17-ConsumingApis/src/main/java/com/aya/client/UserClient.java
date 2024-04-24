package com.aya.client;


import com.aya.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com",name ="USER-CLIENT")
public interface UserClient {


    @GetMapping("/users")
    List<UserDTO> getUsers();







}
