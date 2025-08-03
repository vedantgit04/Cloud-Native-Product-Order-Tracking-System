package com.example.ProductService.Models;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public abstract class BasedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     public Long id;

    private Date createdat;
    private Date updatedat;

    public Long getId() {  // ✅ changed to Long
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }
}
