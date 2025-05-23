package com.example.schedule.service;


import com.example.schedule.dto.SignUpResponseDto;
import com.example.schedule.dto.UserDto.UserResponseDto;
import com.example.schedule.entity.User;
import com.example.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service // 확장될 이유가 없다면 사용 가능, 변경 및 확장 경우가 있다면 인터페이스로 설계
@RequiredArgsConstructor //UserRepository 생성자 주입 받기
public class UserService {

    private final UserRepository userRepository;



    public SignUpResponseDto signUp(String username, String password, Integer age, String email) {

        // 매개변수로 전달받은 애들로 멤버 만들기
        User user = new User(username, password, age, email);

        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getAge(), savedUser.getEmail());
    }

    public UserResponseDto findById(Long id) {

        // Optional로 지정되는 건 null을 안전하게 지정하기 위함
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exist");
        }

        User findUser = optionalUser.get();
        return new UserResponseDto(findUser.getUsername(), findUser.getEmail(), findUser.getAge());

    }
}
