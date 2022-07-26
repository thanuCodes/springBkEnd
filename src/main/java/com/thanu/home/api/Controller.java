package com.thanu.home.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping({"/index"})
    public String loginStatus(){
        return "Welcome to the ThanuSapp";
    }
}
