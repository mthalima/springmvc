package com.mvc.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SysController {

    //add porta para "hello"
    @GetMapping("/hello")
    public String sayHello (Model theModel){
        theModel.addAttribute("theDate", java.time.LocalDateTime.now());

        //esse é o return do nome do arquivo html
        return "helloworld";
    }


}
