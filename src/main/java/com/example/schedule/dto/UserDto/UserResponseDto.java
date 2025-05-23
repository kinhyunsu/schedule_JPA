package com.example.schedule.dto.UserDto;


import lombok.Getter;

@Getter
public class UserResponseDto {

    private final String username;

    private final String email;

    private final Integer age;

    public UserResponseDto(String username, String email, Integer age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
}
