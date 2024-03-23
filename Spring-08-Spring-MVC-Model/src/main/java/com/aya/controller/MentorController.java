package com.aya.controller;


import com.aya.enums.Gender;
import com.aya.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {


    @RequestMapping("/list")
    public String mentor(Model model){

        List<Mentor> mentorList=new ArrayList<>();
        Mentor m1=new Mentor("Adam","Smith", 40, Gender.Male);
        Mentor m2=new Mentor("Amy","Pigeon", 25, Gender.Female);
        Mentor m3=new Mentor("John","Snow", 35, Gender.Male);

        mentorList.add(m1);
        mentorList.add(m2);
        mentorList.add(m3);

        model.addAttribute("mentors",mentorList);
        return "/student/mentor";

    }



}
