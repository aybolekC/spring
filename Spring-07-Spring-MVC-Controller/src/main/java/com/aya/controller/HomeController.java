package com.aya.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Annotate the class with @Controller stereotype annotation
public class HomeController {

    @RequestMapping("/home")  // Use @RequestMapping annotation to associate the action with an HTTP request path
    public String home(){
        return "home.html"; // return the HTML document name that contains the details we want the browser to display
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome.html";
    }
}
