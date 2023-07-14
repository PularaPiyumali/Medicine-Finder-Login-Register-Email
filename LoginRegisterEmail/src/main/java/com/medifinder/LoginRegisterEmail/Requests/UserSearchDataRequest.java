package com.medifinder.LoginRegisterEmail.Requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserSearchDataRequest {

    @JsonProperty("searchName")
    private String searchName;

}
