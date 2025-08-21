package com.example.ProductService.Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
// we are marking the based model as serializable because we are passing its data over the network - redis demands it
public abstract class BasedModel  implements Serializable {

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
