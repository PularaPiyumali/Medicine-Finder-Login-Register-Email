package com.medifinder.LoginRegisterEmail.entities;

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

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JsonIgnore
//    private Set<Location> pharmacyLocation;

//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(referencedColumnName = "userId")
//    @JsonIgnore
//    private User userId;
      private Long userId;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "medicine_pharmacy",
            joinColumns = @JoinColumn(name = "medicine_id"),
            inverseJoinColumns = @JoinColumn(name = "pharmacy_id")
    )
    @JsonIgnore
    private Set<Medicine> addingMedicine = new HashSet<>();
}
