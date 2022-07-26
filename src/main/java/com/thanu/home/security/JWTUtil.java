package com.thanu.home.security;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Value;


public class JwtTokenUtil implements Serializable {
    @Value("${jwt.secret}")
    private String secret;

    public String getUsernameFromToken(String token){

    }
}
