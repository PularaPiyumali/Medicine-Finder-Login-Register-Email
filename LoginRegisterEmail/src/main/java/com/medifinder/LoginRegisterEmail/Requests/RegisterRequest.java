package com.medifinder.LoginRegisterEmail.Requests;


import com.medifinder.LoginRegisterEmail.enums.UserRole;
import lombok.*;

@Data
@Builder
@Getter
@Setter
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private Integer mobileNo;
    private String email;
    private String password;
    private UserRole role;

    public RegisterRequest(String firstName, String lastName, Integer mobileNo, String email, String password, UserRole role) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setMobileNo(mobileNo);
        this.setEmail(email);
        this.setPassword(password);
        this.setRole(role);
    }


}
