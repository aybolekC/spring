package com.aya.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {


    @RequestMapping("/welcome")
    public String homepage(Model model){

        model.addAttribute("name","Aya");
        model.addAttribute("course","MVC");

        return "/student/welcome";
    }


    @RequestMapping("/aya")
    public String homepage2(Model model){

        //values will not be passed to the html page
        return "/student/welcome";
    }
}
