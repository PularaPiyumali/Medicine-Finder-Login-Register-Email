package com.example.LoginRegisterEmail.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
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
    private Long pharmacyId;
    private String pharmacyName;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JsonIgnore
//    private Set<Location> pharmacyLocation;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "userId")
    @JsonIgnore
    private User userId;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "medicine_pharmacy",
            joinColumns = @JoinColumn(name = "medicineId"),
            inverseJoinColumns = @JoinColumn(name = "pharmacyId")
    )
    @JsonIgnore
    private Set<Medicine> addingMedicine = new HashSet<>();
}
