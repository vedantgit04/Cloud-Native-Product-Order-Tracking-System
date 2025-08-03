package com.example.ProductService.DTOs;

import java.util.List;
// we copy this userdto from authantication service

public class UserDto {

    private  String name;
    private  String email;
    private List<Role> roles;
    private  String  isEmailVerified;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(String emailVerified) {
        isEmailVerified = emailVerified;
    }


}
