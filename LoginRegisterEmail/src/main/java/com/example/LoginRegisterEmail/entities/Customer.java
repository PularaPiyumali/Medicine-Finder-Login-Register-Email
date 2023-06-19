package com.example.LoginRegisterEmail.entities;

import com.example.LoginRegisterEmail.entities.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerId")
    private Long customerId;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "userId")
    private List<User> user;
}
