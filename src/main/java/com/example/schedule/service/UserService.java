package com.example.schedule.service;


import com.example.schedule.dto.SignUpResponseDto;
import com.example.schedule.entity.User;
import com.example.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
