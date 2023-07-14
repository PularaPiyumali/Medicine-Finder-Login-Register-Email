package com.medifinder.LoginRegisterEmail.entities;

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
@Table(name = "generic")
public class Generic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long genericId;

    private String name;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Set <Medicine> medicine;

}
