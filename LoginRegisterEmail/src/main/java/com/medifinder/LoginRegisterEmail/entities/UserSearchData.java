package com.medifinder.LoginRegisterEmail.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class UserSearchData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String searchName;
    private LocalDateTime timestamp;

}
