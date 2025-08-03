


//
//// we are implementing this because in the CustomUSerDetails we have the getAuthorities()  which returns granted auth
//// in our case authority is role
//
//package com.UserService.Model;
//
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import org.springframework.security.core.GrantedAuthority;
//
//@JsonDeserialize // This annotation is good to have
//public class CustomGrantedAuthority implements GrantedAuthority {
//    private String authority; // Made this private for better encapsulation
//
//    // No-argument constructor for deserialization
//    public CustomGrantedAuthority() {
//    }
//
//    public CustomGrantedAuthority(Role role){
//        this.authority = role.getName();
//    }
//
//    @Override
//    public String getAuthority() {
//        return authority;
//    }
//
//    // Setter for deserialization
//    public void setAuthority(String authority) {
//        this.authority = authority;
//    }
//}

package com.UserService.Model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.security.core.GrantedAuthority;

@JsonDeserialize
public class CustomGrantedAuthority implements GrantedAuthority {
    private String authority;

    public CustomGrantedAuthority() {
        // No-argument constructor
    }

    public CustomGrantedAuthority(Role role) {
        this.authority = role.getName();
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    // --- Add this setter ---
    public void setAuthority(String authority) {
        this.authority = authority;
    }
}