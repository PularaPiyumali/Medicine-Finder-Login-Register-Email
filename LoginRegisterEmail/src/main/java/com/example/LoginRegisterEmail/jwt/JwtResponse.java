package com.example.LoginRegisterEmail.jwt;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
public class JwtResponse {
        private static final long serialVersionUID = -8091879091924046844L;
        private String jwtToken;

	public JwtResponse(String jwtToken) {
            this.jwtToken = jwtToken;
        }

        public String getToken() {
            return this.jwtToken;
        }
    }


