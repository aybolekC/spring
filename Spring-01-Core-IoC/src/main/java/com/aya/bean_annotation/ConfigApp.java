package com.aya.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigApp {


 // when we have 2 beans for the same class we can default one of the by tagging @Primary
    @Bean
    @Primary
    FullTimeMentor fullTimeMentor(){
        System.out.println("Primary bean for FullTimeMentor");
        return  new FullTimeMentor();
    }

    @Bean
    FullTimeMentor fullTimeMentor2(){
        return  new FullTimeMentor();
    }


    @Bean(name = "p1")
    PartTimeMentor partTimeMentor(){
        return new PartTimeMentor();
    }


//  Below method will cause an error, when we try to create 2 beans for the same class
//No qualifying bean of type 'com.aya.bean_annotation.PartTimeMentor' available: expected single matching bean but found 2: partTimeMentor,partTimeMentor2
//    @Bean
//    PartTimeMentor partTimeMentor2(){
//        return new PartTimeMentor();
//    }

    @Bean(name = "p2")
    PartTimeMentor partTimeMentor2(){
        System.out.println("P2 bean for PartTimeMentor");
        return new PartTimeMentor();
    }
}
