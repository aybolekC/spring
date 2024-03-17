package com.aya;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DealerApp {

    public static void main(String[] args) {

        ApplicationContext container=new AnnotationConfigApplicationContext(ConfigCar.class);

        Car c=container.getBean(Car.class);
        Person p=container.getBean(Person.class);

        System.out.println("Person's name is: " + p.getName());
        System.out.println("Car's make is: " + c.getMake());
        System.out.println("Person's car is: " + p.getCar().getMake());


    }
}
