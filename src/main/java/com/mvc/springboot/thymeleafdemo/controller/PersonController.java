package com.mvc.springboot.thymeleafdemo.controller;

import com.mvc.springboot.thymeleafdemo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("processPersonForm")
    public String processPersonForm(@ModelAttribute("person") Person pessoa){

        //log the input data
        System.out.printf("Pessoa: " + pessoa.getFirstName() + " " + pessoa.getLastName());

        return "person-form";
    }
}
