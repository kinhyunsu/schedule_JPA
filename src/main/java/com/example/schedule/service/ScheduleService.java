package com.example.schedule.service;

import com.example.schedule.dto.ScheduleDto.ScheduleResponseDto;
import com.example.schedule.dto.ScheduleWithResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.entity.User;
import com.example.schedule.repository.ScheduleRepository;
import com.example.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(String title, String contents, String email, String username) {

        User findUser = userRepository.findUserByUsernameOrElseThrow(username);

        Schedule schedule = new Schedule(title, contents, email);
        schedule.setUser(findUser);


        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents(),schedule.getEmail());
    }

    public List<ScheduleResponseDto> findAll() {

        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();

    }


    public ScheduleWithResponseDto findById(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        User writer = findSchedule.getUser();

        return new ScheduleWithResponseDto(findSchedule.getTitle(), findSchedule.getContents(), findSchedule.getEmail());
    }

    public void delete(Long id) {

        Schedule findschedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findschedule);
    }
}

