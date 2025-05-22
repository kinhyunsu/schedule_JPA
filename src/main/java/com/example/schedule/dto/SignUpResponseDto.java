package com.example.schedule.dto;


import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final Long id;

    private final String username;

    private final Integer age;

    private final String email;


    public SignUpResponseDto(Long id, String username, Integer age, String email){
        this.id = id;
        this.username = username;
        this.age = age;
        this.email = email;
    }
}
