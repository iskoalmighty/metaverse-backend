package com.example.metaversebackend.controller;

import com.example.metaversebackend.http.request.user.AuthenticationRequest;
import com.example.metaversebackend.model.user.AuthenticationResponse;
import com.example.metaversebackend.model.user.User;
import com.example.metaversebackend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthenticationController implements AuthenticationApi {

    private final AuthenticationService authenticationService;

    @Override
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(User request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
