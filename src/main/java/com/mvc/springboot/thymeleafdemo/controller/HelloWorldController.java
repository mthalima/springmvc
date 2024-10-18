package com.mvc.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    //metodo para mostrar o form HTML
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //processar o form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processForm")
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
}
