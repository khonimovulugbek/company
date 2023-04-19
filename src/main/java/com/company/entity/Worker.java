package com.company.entity;

import jakarta.persistence.*;
import lombok.*;

/**
Author: Khonimov Ulugbek
Date: 19.04.2023  13:57
*/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
