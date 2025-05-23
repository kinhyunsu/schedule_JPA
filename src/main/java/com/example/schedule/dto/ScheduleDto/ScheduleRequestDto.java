package com.example.schedule.dto.ScheduleDto;


import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private final String title;

    private final String contents;

    private final String username;

    private final String email;

    public ScheduleRequestDto(String title, String contents, String username, String email) {
        this.title = title;
        this.contents = contents;
        this.username = username;
        this.email = email;
    }
}
