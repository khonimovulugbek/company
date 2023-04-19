package com.company.entity;

import jakarta.persistence.*;
import lombok.*;

/**
Author: Khonimov Ulugbek
Date: 19.04.2023  13:52
*/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String corpName;
    private String directorName;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
