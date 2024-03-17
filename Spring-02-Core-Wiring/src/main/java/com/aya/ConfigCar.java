package com.aya;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCar {

    @Bean
    Car car(){
        Car c=new Car();
        c.setMake("Honda");
        return c;
    }

//  Direct wiring calling bean method within another bean method
//    @Bean
//    Person person(){
//        Person p=new Person();
//        p.setName("Mike");
//        p.setCar(car());
//        return p;
//    }


//  AutoWiring
    @Bean
    Person person(Car car){
        Person p=new Person();
        p.setName("Mike");
        p.setCar(car);
        return p;
    }



}
