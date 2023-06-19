package com.example.LoginRegisterEmail.entities;

import com.example.LoginRegisterEmail.entities.Generic;
import com.example.LoginRegisterEmail.entities.Pharmacy;
import jakarta.persistence.*;
import lombok.*;
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

    @OneToMany(mappedBy = "pharmacyagent",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<Pharmacy> pharmacy;

    @OneToMany(mappedBy = "generic",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Generic> genericMedicine;

}
