package com.example.demorestapplication.model.dto;

import com.example.demorestapplication.model.Wallet;
import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private boolean gender;
    private Wallet wallet;

}
