package com.example.LoginRegisterEmail.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
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

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "pharmacyLocation")
//    private Location pharmacyLocation;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    Set<User> user;
}
