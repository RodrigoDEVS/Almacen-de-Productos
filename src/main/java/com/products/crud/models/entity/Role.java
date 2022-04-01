package com.products.crud.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    
    @Id
    @Column(name = "roles")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
