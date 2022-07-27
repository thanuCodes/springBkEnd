package com.thanu.home.api;

import com.thanu.home.entity.auth.Auth;
import com.thanu.home.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControl {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome(){
        return "Welcome to the application";
    }
    @PostMapping("/auth")
    public String generateToken(@RequestBody Auth auth) throws Exception{
        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            auth.getUserName(),
                            auth.getPassword()));

        }catch (Exception ex){

        throw new Exception("Invalid User Name or Password");
        }
        return jwtUtil.generateToken(auth.getUserName());

    }
}
