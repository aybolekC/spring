package com.aya.model.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.aya") - will scan all packages under com.aya
@ComponentScan(basePackages = {"com.aya.proxy", "com.aya.service", "com.aya.repository"})
public class ProjectConfig {
}
