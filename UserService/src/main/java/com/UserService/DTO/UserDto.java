package com.UserService.DTO;

import com.UserService.Model.Role;
import com.UserService.Model.User;
import jakarta.persistence.ManyToMany;

import java.util.List;

public class UserDto {

    private  String name;
    private  String email;
    @ManyToMany
    private List<Role>roles;
    private  String  isEmailVerified;
    // conversion of user to user dto and return user dto
    // i creatd this method as static so that i dont need to ctreate n object to use this method
    public static UserDto from(User user){
        UserDto userdto = new UserDto();
        userdto.setEmail(user.getEmail());
        userdto.setName(user.getName());
        userdto.setEmailVerified(user.getIsEmailVerified());
        userdto.setRoles(user.getRoles());
        return userdto;
    }

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
