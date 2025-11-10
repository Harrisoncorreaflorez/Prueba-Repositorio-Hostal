package com.amefrica.hostal.presentation.controller;

import com.amefrica.hostal.presentation.dto.request.LoginRequestDto;
import com.amefrica.hostal.presentation.dto.request.RegisterDto;
import com.amefrica.hostal.presentation.dto.request.UserRequestDto;
import com.amefrica.hostal.service.interfaces.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {



    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login( @Valid @RequestBody LoginRequestDto loginRequest){

        return ResponseEntity.ok(authenticationService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<?>register(@Valid @RequestBody UserRequestDto userRequestDto){

        return ResponseEntity.ok(authenticationService.register(userRequestDto));
    }



}
