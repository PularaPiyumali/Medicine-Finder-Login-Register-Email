package com.example.LoginRegisterEmail.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "pharmacyagent")
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pharmacyId")
    private Long pharmacyId;

    @Column(name = "pharmacyName")
    private String pharmacyName;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name = "pharmacyLocation")
//    private Set<Location> pharmacyLocation;
//
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    Set<User> user;
}
