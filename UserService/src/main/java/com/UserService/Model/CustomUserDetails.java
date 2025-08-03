//package com.UserService.Model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.sql.Array;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//// first we need to understand what is sserializationa and deserializationa
//// de - json to java object , serialisation - java object to json
//// now by default the spring security not allows any object to be get deserialise like  CustomUserDetails is not allow to get de , so how can we get json output in the postman
//// we need to explicitly map it to get desirialise
//@JsonDeserialize
//public class CustomUserDetails implements UserDetails {
//
//    // we dont have these methods in the usermodel , when we calling the CutomUserDetail with the  input user we need to manually set these values
//    private String password;
//    private String username;
//    private boolean accountNonExpired;
//    private boolean accountNonLocked;
//    private boolean credentialsNonExpired;
//    private boolean enabled;
//    private List<CustomGrantedAuthority> customGrantedAuthorities;
//
//
//
//  public  CustomUserDetails(){
//
//  }
//
//    public  CustomUserDetails(User user){
//        this.username = user.getEmail();
//        this.password = user.getHashedPassword();
//        this.accountNonExpired = true;
//        this.accountNonLocked = true;
//        this.credentialsNonExpired= true;
//        this.enabled= true;
//
//        // user has list<roles>
//        // we need to Convert the list<roles> into list< customGrantedAuthorities>
//
//        List<CustomGrantedAuthority> authorities = new ArrayList<>();
//        for(Role role : user.getRoles()){
//            authorities.add(new CustomGrantedAuthority(role));
//        }
//        customGrantedAuthorities = authorities;
//
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return  customGrantedAuthorities;
//    }
//
//    @Override
//    @JsonIgnore
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return  username;
//    }
//
//    @Override
//    @JsonIgnore
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    @JsonIgnore
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    @JsonIgnore
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    @JsonIgnore
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setAccountNonExpired(boolean accountNonExpired) {
//        this.accountNonExpired = accountNonExpired;
//    }
//
//    public void setAccountNonLocked(boolean accountNonLocked) {
//        this.accountNonLocked = accountNonLocked;
//    }
//
//    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
//        this.credentialsNonExpired = credentialsNonExpired;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    public void setCustomGrantedAuthorities(List<CustomGrantedAuthority> customGrantedAuthorities) {
//        this.customGrantedAuthorities = customGrantedAuthorities;
//    }
//}
//
package com.UserService.Model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonDeserialize // This is still needed
public class CustomUserDetails implements UserDetails {

    private String password;
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    // --- Field renamed to match the getter/setter ---
    private List<CustomGrantedAuthority> authorities;

    public CustomUserDetails() {
        // A no-argument constructor is essential
    }

    public CustomUserDetails(User user) {
        this.username = user.getEmail();
        this.password = user.getHashedPassword();
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;

        // Populate the renamed 'authorities' field
        this.authorities = new ArrayList<>();
        if (user.getRoles() != null) {
            for (Role role : user.getRoles()) {
                this.authorities.add(new CustomGrantedAuthority(role));
            }
        }
    }

    // --- The Getter from the UserDetails interface ---
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    // --- The matching Setter that Jackson needs ---
    public void setAuthorities(List<CustomGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    // --- Getters and Setters for all other fields ---
    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
