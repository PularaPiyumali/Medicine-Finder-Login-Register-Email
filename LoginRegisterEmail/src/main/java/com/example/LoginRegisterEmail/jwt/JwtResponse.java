package com.example.LoginRegisterEmail.jwt;

import com.example.LoginRegisterEmail.entities.UserRole;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
public class JwtResponse {
        private static final long serialVersionUID = -8091879091924046844L;
        private String jwtToken;
        private UserRole role;


    public JwtResponse(String jwtToken, UserRole role) {
        this.jwtToken = jwtToken;
        this.role = role;
    }

    public UserRole getRole() {
        return role;
    }

    public String getToken() {
            return this.jwtToken;
        }
    }




