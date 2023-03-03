package com.example.demorestapplication.model;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private boolean gender;
    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}
