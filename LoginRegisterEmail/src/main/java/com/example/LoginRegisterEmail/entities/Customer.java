package com.example.LoginRegisterEmail.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerId")
    private Long customerId;

//   @OneToMany(cascade = CascadeType.ALL)
//   @JoinColumn(name = "userId")
//   private List<User> user;
}
