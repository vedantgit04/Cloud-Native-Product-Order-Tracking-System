package com.example.ProductService.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product extends BasedModel {
//    @Id
//    private long id;
    private String title;
    private double price;
    @ManyToOne(cascade = {CascadeType.ALL}) // this will perform all the oprations as it is on catogory object as product because cascade type is All
    private Catogory catogory;
    private String discription;
    private String image;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Catogory getCatogory() {
        return catogory;
    }

    public void setCatogory(Catogory catogory) {
        this.catogory = catogory;
    }
}
