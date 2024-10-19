package com.mvc.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //metodo para mostrar o form HTML
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //processar o form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormV2")
    public String minParaMaiu(HttpServletRequest request, Model model){
        //le o parametro requisitado da form
        String theName = request.getParameter("personName");

        //realiza alguma coisa
        theName = theName.toUpperCase();

        //cria uma msg
        String result = "Yo! " + theName;

        //add para o modelo
        model.addAttribute("message", result);

        return "helloworld";
    }

    @GetMapping("/processFormV3")
    public String processFormVersion3(@RequestParam("personName") String theName, Model model){


        //realiza alguma coisa
        theName = theName.toUpperCase();

        //cria uma msg
        String result = "hello my friend from v3" + theName;

        //add para o modelo
        model.addAttribute("message", result);

        return "helloworld";
    }
}
