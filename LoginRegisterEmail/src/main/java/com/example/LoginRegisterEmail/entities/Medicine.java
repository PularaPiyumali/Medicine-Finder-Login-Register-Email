package com.example.LoginRegisterEmail.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name = "medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long medicineId;

    private String medicineName;

    private String medicineDescription;

    private double medicinePrice;

    private int medicineQuantity;

    @ManyToMany (mappedBy = "addingMedicine")
    private Set <Pharmacy> medicineSet = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medicine_generic_id", referencedColumnName = "genericId")
    private Generic generic;

    //private Long genericId;


}
