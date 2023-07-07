package com.medifinder.LoginRegisterEmail.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;

    private String address;

    private String city;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private Long pharmacyId;

    //@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "pharmacy_id", referencedColumnName = "locationId")
    //private Pharmacy pharmacy;
}
