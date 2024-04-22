package org.nailproject.controllers;

import lombok.RequiredArgsConstructor;
import org.nailproject.dto.auth.AuthRequest;
import org.nailproject.dto.auth.AuthResponse;
import org.nailproject.services.auth.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;


    @PostMapping
    public ResponseEntity<AuthResponse> authenticateClient(@RequestBody AuthRequest authRequest) {
        String clientsEmail = authRequest.getEmail();

        var authenticationToken = new UsernamePasswordAuthenticationToken(clientsEmail, authRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(clientsEmail);

        return ResponseEntity.ok(new AuthResponse(jwt));

    }

    @GetMapping
    public ResponseEntity<?> authenticateAndGetToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized: No token generated for anonymous user");
        } else {
            String email = authentication.getName();
            String token = jwtTokenProvider.generateToken(email);
            return ResponseEntity.ok(new AuthResponse(token));
        }
    }

}
