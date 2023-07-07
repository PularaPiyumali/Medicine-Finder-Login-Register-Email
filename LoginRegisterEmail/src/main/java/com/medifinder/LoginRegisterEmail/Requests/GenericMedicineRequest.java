package com.medifinder.LoginRegisterEmail.Requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericMedicineRequest {

    @JsonProperty("generic_id")
    private Long genericId;
}
