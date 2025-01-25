package dev.invencio.Invencio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.invencio.Invencio.dto.LoginRequest;
import dev.invencio.Invencio.dto.LoginResponse;
import dev.invencio.Invencio.service.InvencioService;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final InvencioService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String userId = adminService.loginAdmin(loginRequest.getUsername(), loginRequest.getPassword());
        if (userId != null) {
            return ResponseEntity.ok(new LoginResponse("Login successful", userId));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse("Invalid username or password", null));
        }
    }

}
