package com.products.crud.controllers;

import com.products.crud.models.dao.ProductRepository;
import com.products.crud.models.dao.ProductService;
import com.products.crud.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public String showProductList(Model model){
        model.addAttribute("titulo", "Listado de Productos");
        model.addAttribute("productos", service.listAll());
        return "products";
    }

    @GetMapping("/products/new")
    public String showNewProductForm(Model model){
        model.addAttribute("titulo", "Nuevo Producto");
        model.addAttribute("product", new Producto());
        return "new";
    }
}
