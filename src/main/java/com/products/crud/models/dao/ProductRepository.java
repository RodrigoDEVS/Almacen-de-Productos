package com.products.crud.models.dao;

import com.products.crud.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Producto, Long> {
}
