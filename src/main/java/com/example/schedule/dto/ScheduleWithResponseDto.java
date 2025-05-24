package com.example.schedule.dto;


import lombok.Getter;

@Getter
public class ScheduleWithResponseDto {

    private final String title;

    private final String contents;

    private final String email;

    public ScheduleWithResponseDto(String title, String contents, String email) {
        this.title = title;
        this.contents = contents;
        this.email = email;
    }


}
