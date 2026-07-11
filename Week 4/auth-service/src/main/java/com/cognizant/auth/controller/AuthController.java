package com.cognizant.auth.controller;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
 private final JwtEncoder encoder;
 public AuthController(JwtEncoder encoder) { this.encoder = encoder; }
 @PostMapping("/auth/token")
 public Map<String,Object> token(@RequestParam(defaultValue="student") String username) {
   Instant now = Instant.now();
   JwtClaimsSet claims = JwtClaimsSet.builder().issuer("week4-auth-service").issuedAt(now)
     .expiresAt(now.plus(1, ChronoUnit.HOURS)).subject(username).claim("scope", "read write").build();
   String token = encoder.encode(JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims)).getTokenValue();
   return Map.of("access_token", token, "token_type", "Bearer", "expires_in", 3600);
 }
 @GetMapping("/secure/profile") public Map<String,String> profile(Authentication auth) {
   return Map.of("message", "JWT authentication successful", "user", auth.getName());
 }
}
