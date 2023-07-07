package com.medifinder.LoginRegisterEmail.jwt;

import com.medifinder.LoginRegisterEmail.entities.UserRole;
import lombok.NoArgsConstructor;


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




