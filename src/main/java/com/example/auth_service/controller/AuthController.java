package com.example.auth_service.controller;

import com.example.auth_service.dto.JwtAuthenticationResponse;
import com.example.auth_service.dto.UserDto;
import com.example.auth_service.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
@Tag(name = "Контроллер авторизации и аутентификации пользователей")
public class AuthController {
    private final AuthenticationService authenticationService;
    @Operation(
            summary = "Регистрация пользователя",
            description = "Позволяет зарегистрировать пользователя"
    )
    @PostMapping("/signup")
    public JwtAuthenticationResponse signUp(@RequestBody UserDto userDto) {
            return authenticationService.signUp(userDto);
    }
    @Operation(
            summary = "Авторизация пользователя",
            description = "Позволяет авторизировать пользователя"
    )
    @PostMapping("/signin")
    public JwtAuthenticationResponse signIn(@RequestBody UserDto userDto) {

        return authenticationService.signIn(userDto);

    }

}
