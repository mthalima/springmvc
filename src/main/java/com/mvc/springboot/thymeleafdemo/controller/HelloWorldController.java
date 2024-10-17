package com.mvc.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    //metodo para mostrar o form HTML
    @RequestMapping
    public String showForm(){
        return "helloworld-form";
    }

    //processar o form
}
