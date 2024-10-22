package com.mvc.springboot.thymeleafdemo.controller;

import com.mvc.springboot.thymeleafdemo.model.Produto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class productController {

    @Value("${categorias}")
    private List<String> categorias;

    @GetMapping("/addProduct")
    public String addProd(Model theModel){

        Produto esseProduto = new Produto();

        theModel.addAttribute("produto", esseProduto);

        //add a lista de paises ao modelo
        theModel.addAttribute("categorias", categorias);

        return "form-produto";
    }

}
