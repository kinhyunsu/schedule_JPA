package com.example.schedule.dto;


import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final String username;

    private final String password;

    private final Integer age;

    private final String email;


    public SignUpRequestDto(String username, String password, Integer age, String email) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.email = email;
    }
}
