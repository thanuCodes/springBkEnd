package com.thanu.home.repository;

import com.thanu.home.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
    User findByUserName(String username);

    boolean existsUserByEmail (String email);


}
