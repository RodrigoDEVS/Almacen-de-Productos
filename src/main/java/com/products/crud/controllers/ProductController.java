package com.products.crud.controllers;

import com.products.crud.models.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de Productos");
        model.addAttribute("productos", repo.findAll());
        return "listar";
    }
}
