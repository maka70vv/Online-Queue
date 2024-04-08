package org.exaple.online_queue.controllers;

import lombok.RequiredArgsConstructor;
import org.exaple.online_queue.responces.AuthRequest;
import org.exaple.online_queue.responces.AuthResponse;
import org.exaple.online_queue.responces.RegisterRequest;
import org.exaple.online_queue.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/token")
    public ResponseEntity<AuthResponse> token(
            @RequestBody AuthRequest request
    ){
        return ResponseEntity.ok(authService.auth(request));
    }
}