package com.products.crud.models.dao;

import com.products.crud.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Producto> listAll(){
        return (List<Producto>) repo.findAll();
    }

    public void save(Producto productos) {
        repo.save(productos);
    }

    public Producto get(Long id) throws ProductNotFoundException {
        Optional<Producto> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new ProductNotFoundException("No se pudo encontrar el producto con el ID " + id);
    }

    public void delete(Long id) throws ProductNotFoundException{
        Long count = repo.countById(id);
        if(count == null || count == 0){
            throw new ProductNotFoundException("No se pudo encontrar el producto con el ID " + id);
        }
        repo.deleteById(id);
    }
}
