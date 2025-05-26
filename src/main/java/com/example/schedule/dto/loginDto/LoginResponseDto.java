package com.example.schedule.dto.loginDto;

import lombok.Getter;
import lombok.extern.java.Log;

@Getter
public class LoginResponseDto {
    private final Long id;

    private final String username;

    private final String email;


    public LoginResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
