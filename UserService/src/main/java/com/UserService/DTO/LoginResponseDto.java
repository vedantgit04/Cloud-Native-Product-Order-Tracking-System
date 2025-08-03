package com.UserService.DTO;

import com.UserService.Model.Token;

public class LoginResponseDto {

    private Token token;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

}
