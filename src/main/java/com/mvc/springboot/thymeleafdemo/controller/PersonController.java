package com.mvc.springboot.thymeleafdemo.controller;

import com.mvc.springboot.thymeleafdemo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @GetMapping("/showPersonForm")
    public String showForm(Model theModel){

        //cria um obj pessoa
        Person pessoa = new Person();

        //add o obj pessoa ao modelo
        theModel.addAttribute("person", pessoa);

        return "person-form";
    }
}
