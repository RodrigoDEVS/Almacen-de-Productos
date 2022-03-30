package com.products.crud.models.dao;

import com.products.crud.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Producto> listAll(){
        return (List<Producto>) repo.findAll();
    }
}
