package com.example.auth_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {
    @GetMapping
    public ResponseEntity<?> example(){
        return ResponseEntity.ok("Hello " + SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
