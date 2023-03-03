package com.example.demorestapplication.controller;

import com.example.demorestapplication.model.User;
import com.example.demorestapplication.model.Wallet;
import com.example.demorestapplication.model.dto.UserDTO;
import com.example.demorestapplication.repository.UserRepository;
import com.example.demorestapplication.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WalletRepository walletRepository;

    //localhost:8081/user/all
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(201).body(userRepository.findAll());
    }

    // localhost:8081/user/insert -> thực hiện insert user
    @PostMapping(value = "/insert")
    public ResponseEntity<User> insertUser(@RequestBody UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setGender(userDTO.isGender());
        Wallet wallet = new Wallet();
        wallet.setBalance(userDTO.getWallet().getBalance());
        wallet.setAccountNumber(userDTO.getWallet().getAccountNumber());
        walletRepository.saveAndFlush(wallet);
        user.setWallet(wallet);
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }
}
