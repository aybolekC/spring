package com.aya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Spring17ConsumingApisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring17ConsumingApisApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }



//    https://jsonplaceholder.typicode.com/users
//    https://www.jsonschema2pojo.org/

}
