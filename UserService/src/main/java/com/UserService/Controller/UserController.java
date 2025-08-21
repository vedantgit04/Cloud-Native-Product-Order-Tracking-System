package com.UserService.Controller;

import com.UserService.DTO.*;
import com.UserService.Exceptions.InvalidPasswordException;
import com.UserService.Exceptions.InvalidTokenException;
import com.UserService.Model.Token;
import com.UserService.Model.User;
import com.UserService.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/signup")
    public UserDto SignUp(@RequestBody SignUpRequestDto signUpRequestDto){

        User user = userService.SignUp(
                signUpRequestDto.getName(),
                signUpRequestDto.getEmail(),
                signUpRequestDto.getPassword()
        );

        return UserDto.from(user); // we write conversion code in the userdto

    }

    @PostMapping("/login")
    public LoginResponseDto LogIn(@RequestBody LoginRequestDto loginRequestDto) throws InvalidPasswordException {

        Token  token =   userService.LogIn(loginRequestDto.getEmail(),loginRequestDto.getPassword());
         LoginResponseDto loginResponseDto = new LoginResponseDto();
         loginResponseDto.setToken(token);
         return loginResponseDto;
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> LogOut (@RequestBody LogOutRequestDto logOutRequestDto){
        ResponseEntity<Void> responseEntity = null;
           try{
              userService.LogOut(logOutRequestDto.getToken());
               responseEntity = new ResponseEntity<>(HttpStatusCode.valueOf(200));
           }catch (Exception e){
             responseEntity= new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           }
          return responseEntity;
    }

 // product service need the roles of user to validatet the authorazation thats why we are passing the UserDto
    @PostMapping("/validatetoken/{token}")
    public UserDto ValidateToken(@PathVariable  String token) throws InvalidTokenException {
         User user = userService.ValidateToken(token);
         return UserDto.from(user);
    }

    @GetMapping("/getbyid/{id}")
    public  ResponseEntity<String>getbyid(@PathVariable("id") Long id){
        return new ResponseEntity<>("call by userservice",HttpStatusCode.valueOf(200));
    }

}
