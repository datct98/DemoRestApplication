package com.example.demorestapplication.repository;

import com.example.demorestapplication.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
}
