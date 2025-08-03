package com.UserService.Model;


import jakarta.persistence.Entity;

@Entity
public class Role extends  BasedModelClass{

    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
