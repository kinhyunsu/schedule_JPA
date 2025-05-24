package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleDto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleDto.ScheduleResponseDto;
import com.example.schedule.dto.ScheduleWithResponseDto;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    //all이기 때문에 굳이 파라미터 쓸 필요 없음
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();
        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleWithResponseDto> findById(@PathVariable Long id) {
        ScheduleWithResponseDto scheduleWithResponseDto = scheduleService.findById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        scheduleService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
