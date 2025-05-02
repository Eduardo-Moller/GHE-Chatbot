package br.com.ghe.chatbot.controller;

import br.com.ghe.chatbot.dto.request.LoginRequest;
import br.com.ghe.chatbot.dto.request.RegisterUserRequest;
import br.com.ghe.chatbot.dto.response.LoginResponse;
import br.com.ghe.chatbot.dto.response.UserResponse;
import br.com.ghe.chatbot.service.LoginService;
import br.com.ghe.chatbot.service.RegisterUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final RegisterUserService registerUserService;
    private final LoginService loginService;

    @PostMapping("/register")
    public UserResponse register(@Valid @RequestBody RegisterUserRequest request) {
        return registerUserService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return loginService.login(request);
    }
}

