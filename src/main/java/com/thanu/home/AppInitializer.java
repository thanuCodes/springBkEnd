package com.thanu.home;

import com.thanu.home.entity.User;
import com.thanu.home.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class AppInitializer {
    @Autowired
    private UserRepository repository;
 @PostConstruct
    public void initUser(){
        List<User> users = Stream.of(
                new User(UUID.randomUUID().toString(),"thanura","pass1","sample@exmple1.com"),
                new User(UUID.randomUUID().toString(),"nilni","pass2","sample@exmple2.com"),
                new User(UUID.randomUUID().toString(),"chandrani","pass3","sample@exmple3.com"),
                new User(UUID.randomUUID().toString(),"gamini","pass4","sample@exmple4.com")

        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(AppInitializer.class, args);
    }

}
