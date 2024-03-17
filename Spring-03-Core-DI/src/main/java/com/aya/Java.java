package com.aya;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Java {

    //Field Injection
    //@Autowired  - one of the ways injecting dependency
//    @Autowired
//    OfficeHours officeHours;

    //Constructor Injection
//    OfficeHours officeHours;
//
//    @Autowired
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

//    //Constructor Injection without @Autowired annotation also will work after spring 4.3
//    OfficeHours officeHours;
//
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }


    OfficeHours officeHours;

    public void getTeachingHours(){
        System.out.println("Weekly teaching hours is: " + (20 + officeHours.getHours() ));
    }
}
