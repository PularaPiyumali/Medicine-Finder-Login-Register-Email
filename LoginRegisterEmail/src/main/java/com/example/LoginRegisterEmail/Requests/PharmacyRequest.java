package com.example.LoginRegisterEmail.Requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PharmacyRequest {

    @JsonProperty("pharmacy_name")
    private String pharmacyName;


}
