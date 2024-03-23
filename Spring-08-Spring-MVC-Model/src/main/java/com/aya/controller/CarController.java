package com.aya.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car")
public class CarController {

    //using query parameter - matching based on key value pair
    @RequestMapping("/info")  //localhost:8080/car/info?make=Honda&year=2020
    public String carInfo(@RequestParam String make,@RequestParam Integer year, Model model){

        model.addAttribute("make",make);
        model.addAttribute("year",year);
        //System.out.println(make);
        return "/car/car-info";
    }


    //making query param optional with default value
    @RequestMapping("/info2")  //localhost:8080/car/info?make=Honda&year=2020
    public String carInfo2(@RequestParam(value = "make", required = false, defaultValue = "Tesla") String make, Model model){

        model.addAttribute("make",make);
        return "/car/car-info";
    }

    //using path variable - making match based on position
    @RequestMapping("/info/{make}/{year}")  //localhost:8080/car/info/Honda/2020
    public String getCarInfo(@PathVariable String make, @PathVariable Integer year, Model model){

        model.addAttribute("make", make);
        model.addAttribute("year", year);

        return "car/car-info";
    }
}
