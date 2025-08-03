package com.example.ProductService.Commons;


import com.example.ProductService.DTOs.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.util.EnumUtils;


@Component // becuse we need the object of this
// if we need to connect to services we need to copy the dto and associated class which we returnning like in our case we returnning userdto
public class AuthorazationCommons {
     private RestTemplate restTemplate;
     AuthorazationCommons(RestTemplate restTemplate){
         this.restTemplate = restTemplate;
     }

     public UserDto ValidateToken(String token){
         // call userservice validate api to validate this token
         ResponseEntity<UserDto> response = restTemplate.postForEntity(
                 "http://localhost:8080/user/validatetoken/" + token,null,UserDto.class
         );
         if(response.getBody() == null){
             // token is invalid
             return null;
         }
         return response.getBody();
     }

}
