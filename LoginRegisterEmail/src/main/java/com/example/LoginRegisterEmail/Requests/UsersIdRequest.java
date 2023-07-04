package com.example.LoginRegisterEmail.Requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersIdRequest {

    @JsonProperty("user_id")
    private Long userId;

}
