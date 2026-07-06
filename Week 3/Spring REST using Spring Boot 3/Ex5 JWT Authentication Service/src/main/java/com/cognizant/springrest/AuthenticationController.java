package com.cognizant.springrest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AuthenticationController {
    private final JwtUtil jwtUtil = new JwtUtil();

    @PostMapping("/authenticate")
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest) {
        if ("user".equals(authRequest.getUsername()) && "pwd".equals(authRequest.getPassword())) {
            return new AuthResponse(jwtUtil.generateToken(authRequest.getUsername()));
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
    }
}
