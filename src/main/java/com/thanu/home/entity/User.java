package com.thanu.home.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "USER_TABLE")
public class User implements Serializable {
    @Id
    private String id;
    private String userName;
    private String password;
    private String email;
}
