package org.scaler.userauthservice.Controller;

import org.scaler.userauthservice.Services.UserService;
import org.scaler.userauthservice.dto.LoginRequestDto;
import org.scaler.userauthservice.dto.LoginResponseDto;
import org.scaler.userauthservice.dto.SignUpRequestDto;
import org.scaler.userauthservice.dto.SignUpResponseDto;
import org.scaler.userauthservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        User user = userService.signUp(signUpRequestDto);
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        signUpResponseDto.setEmail(user.getEmail());
        signUpResponseDto.setName(user.getName());
        return ResponseEntity.ok(signUpResponseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto)
    {
        User user = userService.login(loginRequestDto);
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setEmail(user.getEmail());
        loginResponseDto.setName(user.getName());
        return ResponseEntity.ok(loginResponseDto);
    }
}
