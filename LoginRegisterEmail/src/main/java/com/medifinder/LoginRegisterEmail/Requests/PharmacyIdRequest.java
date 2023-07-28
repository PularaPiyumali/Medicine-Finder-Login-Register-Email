package com.medifinder.LoginRegisterEmail.Requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PharmacyIdRequest {

    @JsonProperty("pharmacy_id")
    private Long pharmacyId;
}
