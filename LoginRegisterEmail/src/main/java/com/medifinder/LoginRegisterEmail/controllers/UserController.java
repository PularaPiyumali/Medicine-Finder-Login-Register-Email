package com.medifinder.LoginRegisterEmail.controllers;


import com.medifinder.LoginRegisterEmail.Requests.UserRequest;
import com.medifinder.LoginRegisterEmail.entities.User;
import com.medifinder.LoginRegisterEmail.entities.UserRole;

import com.medifinder.LoginRegisterEmail.registration.RegisterRequest;
import com.medifinder.LoginRegisterEmail.registration.RegistrationService;
import com.medifinder.LoginRegisterEmail.repository.UserRepository;
import com.medifinder.LoginRegisterEmail.services.UserService;
import com.medifinder.LoginRegisterEmail.jwt.JwtResponse;
import com.medifinder.LoginRegisterEmail.jwt.JwtTokenUtil;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(path = "api/v1")
public class UserController {

    private RegistrationService registrationService;
    private JwtTokenUtil jwtTokenUtil;
    private AuthenticationManager authenticationManager;
    private UserService customUserDetailsService;
    private UserRepository userRepository;


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
        //return ResponseEntity.ok(new JwtResponse(token));
        final UserRole userRole = user.getUserRole();

        JwtResponse response = new JwtResponse(token, userRole);

        return ResponseEntity.ok(response);


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

    @GetMapping("users/all")
    public List<User> getAllMedicines() {
        return userRepository.findAll();
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity <User> updateMedicine (@PathVariable Long userId, @RequestBody UserRequest updatedUser){
        User updated = customUserDetailsService.updateUserDetails(userId, updatedUser);
        return ResponseEntity.ok(updated);
    }

}
