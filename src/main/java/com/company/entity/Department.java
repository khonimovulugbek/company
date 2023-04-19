package com.company.entity;

import jakarta.persistence.*;
import lombok.*;

/**
Author: Khonimov Ulugbek
Date: 19.04.2023  13:59
*/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
