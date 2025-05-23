package com.example.schedule.dto.ScheduleDto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String title;

    private final String contents;

    private final String email;

    public ScheduleResponseDto(Long id, String title, String contents, String email) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.email = email;
    }
}
