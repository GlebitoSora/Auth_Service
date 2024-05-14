package com.example.auth_service.controller;

import com.example.auth_service.dto.JwtAuthenticationResponse;
import com.example.auth_service.dto.UserDto;
import com.example.auth_service.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserDto userDto) {
        try {
            return ResponseEntity.ok(authenticationService.signUp(userDto));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody UserDto userDto) {
        try {
            return ResponseEntity.ok(authenticationService.signIn(userDto));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

}
