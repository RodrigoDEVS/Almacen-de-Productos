package com.products.crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("")
    public String showHomePage(Model model){
        model.addAttribute("tituloHome", "Página Inicial");
        return "index";
    }
}
