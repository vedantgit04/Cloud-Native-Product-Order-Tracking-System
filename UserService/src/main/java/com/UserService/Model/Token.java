package com.UserService.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Token extends BasedModelClass{ // It extends BasedModelClass, so it inherits 'deleted'

    private  String value;
    @ManyToOne
    private  User user;
    private Date expiredAt;

    // The 'deleted' field is inherited from BasedModelClass.
    // Your setter in LogOut() is already trying to use it: `token.setIsdeleted(true);`
    // The changes in BasedModelClass will automatically apply here.

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }
}