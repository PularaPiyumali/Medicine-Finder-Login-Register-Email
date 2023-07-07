package com.medifinder.LoginRegisterEmail.Requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {

    @JsonProperty("customer_username")
    private String customerUsername;
}
