package com.UserService.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BasedModelClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Change this from 'boolean' to 'Boolean' and initialize it
    private Boolean deleted = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // This getter/setter pair is now consistent with the field type
    public Boolean getIsdeleted() {
        return deleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.deleted = isdeleted;
    }
}