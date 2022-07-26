package com.thanu.home.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControl {

    @GetMapping("/")
    public String welcome(){
        return "Welcome to the application";
    }
}
