package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleDto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleDto.ScheduleResponseDto;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto scheduleRequestDto) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.save(scheduleRequestDto.getTitle(), scheduleRequestDto.getContents(), scheduleRequestDto.getEmail(), scheduleRequestDto.getUsername());

        return new ResponseEntity<>(scheduleResponseDto,HttpStatus.CREATED);
    }
}
