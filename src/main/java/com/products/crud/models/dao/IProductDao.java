package com.products.crud.models.dao;

import com.products.crud.models.entity.Producto;

import java.util.List;

public interface IProductDao {

    public List<Producto> findAll();
}
