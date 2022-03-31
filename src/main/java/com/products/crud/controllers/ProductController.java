package com.products.crud.controllers;

import com.products.crud.models.dao.ProductNotFoundException;
import com.products.crud.models.dao.ProductRepository;
import com.products.crud.models.dao.ProductService;
import com.products.crud.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public String showProductList(Model model){
        model.addAttribute("pageTitle", "Listado de Productos");
        model.addAttribute("productos", service.listAll());
        return "products";
    }

    @GetMapping("/products/new")
    public String showNewProductForm(Model model){
        model.addAttribute("pageTitle", "Nuevo Producto");
        model.addAttribute("productos", new Producto());
        return "product_form";
    }

    @PostMapping("/products/save")
    public String saveProduct(Producto productos, RedirectAttributes ra){
        service.save(productos);
        ra.addFlashAttribute("message", "Se ha creado el nuevo producto");
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra){
        try {
            Producto product = service.get(id);
            model.addAttribute("productos", product);
            model.addAttribute("pageTitle", "Modificar Producto (ID: " + id + ")");
            return "product_form";
        } catch (ProductNotFoundException e) {
            ra.addFlashAttribute("message", "El Producto No Existe");
            return "redirect:/products";
        }
    }

    @GetMapping("/products/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, RedirectAttributes ra){
        try{
            service.delete(id);
            ra.addFlashAttribute("message", "El producto con ID: " + id + " ha sido eliminado");
        }catch (ProductNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/products";
    }
}
