package com.mvc.springboot.thymeleafdemo.controller;

import com.mvc.springboot.thymeleafdemo.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PersonController {

    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/showPersonForm")
    public String showForm(Model theModel){

        //cria um obj pessoa
        Person pessoa = new Person();

        //add o obj pessoa ao modelo
        theModel.addAttribute("person", pessoa);

        //add a lista de paises ao modelo
        theModel.addAttribute("countries", countries);

        return "person-form";
    }

    @PostMapping("processPersonForm")
    public String processPersonForm(@ModelAttribute("person") Person pessoa){

        //entrada do form no log >
        System.out.printf("Pessoa: " + pessoa.getFirstName() + " " + pessoa.getLastName());

        return "person-confirmation";
    }
}
