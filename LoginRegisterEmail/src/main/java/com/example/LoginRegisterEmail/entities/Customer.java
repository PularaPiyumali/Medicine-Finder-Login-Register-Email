package com.example.LoginRegisterEmail.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long customerId;
    private String customerUsername;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonIgnore
//    private User user;

    private Long userId;
}
