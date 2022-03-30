package com.products.crud;

import com.products.crud.models.dao.ProductRepository;
import com.products.crud.models.entity.Producto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProductRepositoryTest {
    @Autowired private ProductRepository repo;

    @Test
    public void testAddNew(){
        Producto product = new Producto();
        product.setName("Huawei Matepad 10.4");
        product.setBrand("Huawei");
        product.setMadeIn("China");
        product.setPrice(850000);

        Producto savedProducto = repo.save(product);

        Assertions.assertThat(savedProducto).isNotNull();
        Assertions.assertThat(savedProducto.getId()).isGreaterThan(0);
    }
}
