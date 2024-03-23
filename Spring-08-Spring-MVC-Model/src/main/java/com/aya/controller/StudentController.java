package com.aya.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {


    @RequestMapping("/welcome")
    public String homepage(Model model){

        model.addAttribute("name","Aya");
        model.addAttribute("course","MVC");

        String subject="Collections";
        model.addAttribute("subject",subject);

        //create some random student ID(1-1000) and show it in your UI
        int studentId=new Random().nextInt();
        model.addAttribute("id",studentId);

        List<Integer> numbers=new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
        numbers.add(10);
        model.addAttribute("numbers",numbers);


        return "/student/welcome";
    }


    @RequestMapping("/aya")
    public String homepage2(Model model){

        //values will not be passed to the html page
        return "/student/welcome";
    }
}
