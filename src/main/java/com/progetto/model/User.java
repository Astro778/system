package com.progetto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String hashPassword;

    public User(String name, String email, String hashedPassword) {
        this.name = name;
        this.email = email;
        this.hashPassword = hashedPassword;
    }
    //lombok handles the constructors, so it's a W bro
}