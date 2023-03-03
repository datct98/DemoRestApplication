package com.example.demorestapplication.model;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String accountNumber;
    private double balance;
}
