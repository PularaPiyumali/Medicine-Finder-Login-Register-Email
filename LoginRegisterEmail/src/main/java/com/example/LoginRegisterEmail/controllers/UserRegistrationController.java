package com.example.LoginRegisterEmail.controllers;


import com.example.LoginRegisterEmail.entities.User;
import com.example.LoginRegisterEmail.jwt.*;
import com.example.LoginRegisterEmail.registration.RegisterRequest;
import com.example.LoginRegisterEmail.registration.RegistrationService;
import com.example.LoginRegisterEmail.services.UserService;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(path = "api/v1")
public class UserRegistrationController {

    private RegistrationService registrationService;
    private JwtTokenUtil jwtTokenUtil;
    private AuthenticationManager authenticationManager;
    private UserService customUserDetailsService;


    @PostMapping(path = "/registration")
    public String register (@RequestBody RegisterRequest request){
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final User user = (User) customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new JwtResponse(token));

    }
    private void authenticate(String username, String password) throws Exception {
        try {
            Objects.requireNonNull(username);
            Objects.requireNonNull(password);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
