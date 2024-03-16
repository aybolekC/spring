package com.aya.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AyaApp {

    public static void main(String[] args) {

        ApplicationContext container=new AnnotationConfigApplicationContext(ConfigApp.class,ConfigAny.class);

       FullTimeMentor ft=container.getBean(FullTimeMentor.class);

       ft.createAccount();

       String st=container.getBean(String.class);
       System.out.println(st);

       Integer number=container.getBean(Integer.class);
       System.out.println(number);

    }
}
