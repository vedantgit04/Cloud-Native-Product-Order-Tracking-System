package com.example.ProductService.DTOs;


import jakarta.persistence.Entity;

// for the userdto we have role as attribute so we copy role as well but here it just a dummmy because we are not going to create an table of this in database
public class Role {
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
