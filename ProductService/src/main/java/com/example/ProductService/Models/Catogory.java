package com.example.ProductService.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Catogory extends BasedModel{
//    @Id
//    private  long id;  this is move to the based model class because these are the audit attributes they need to store in seperates class to reduce redendency

//    @OneToMany(cascade = {CascadeType.REMOVE}); // remove the project with the given catogory object as well while deleting the catogory
//  private List<Product>products;  it is giving us an erro because relation or cardinality is already define between catogory and product

    @OneToMany(mappedBy = "catogory" ,cascade = {CascadeType.REMOVE}) //this is for mappedby -- catogory is the varible name in the product class where the cardinality is define
    List<Product> products;

    private  String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
