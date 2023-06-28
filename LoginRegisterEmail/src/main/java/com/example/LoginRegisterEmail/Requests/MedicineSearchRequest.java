package com.example.LoginRegisterEmail.Requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicineSearchRequest {

    @JsonProperty("medicine_name")
    private String medicineName;
}
