package com.medifinder.LoginRegisterEmail.exceptions;

public class MedicineNotFoundException extends RuntimeException{

    public MedicineNotFoundException(String message){
        super(message);
    }
}
