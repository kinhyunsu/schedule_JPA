package com.example.schedule.controller;


import com.example.common.session.SessionConst;
import com.example.schedule.dto.SignUpRequestDto;
import com.example.schedule.dto.SignUpResponseDto;
import com.example.schedule.dto.UserDto.UpdatePasswordRequestDto;
import com.example.schedule.dto.UserDto.UserResponseDto;
import com.example.schedule.dto.loginDto.LoginRequestDto;
import com.example.schedule.dto.loginDto.LoginResponseDto;
import com.example.schedule.entity.User;
import com.example.schedule.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request) {

        User loginUser = userService.login(loginRequestDto);
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginUser.getId());
        return new ResponseEntity<>(new LoginResponseDto(loginUser.getId(), loginUser.getUsername(), loginUser.getEmail()), HttpStatus.OK);



    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto =
                userService.signUp(
                        requestDto.getUsername(),
                        requestDto.getPassword(), requestDto.getAge(),
                        requestDto.getEmail()
                );


        return new ResponseEntity<>(signUpResponseDto,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.findById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordRequestDto requestDto

            ) {
        userService.updatePassword(id, requestDto.getOldPassword(), requestDto.getNewPassword());


        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
