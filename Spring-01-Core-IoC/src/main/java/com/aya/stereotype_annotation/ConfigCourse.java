package com.aya.stereotype_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.aya") -- will scan all packages under com.aya package and create beans from available classes
@ComponentScan
public class ConfigCourse {


}
