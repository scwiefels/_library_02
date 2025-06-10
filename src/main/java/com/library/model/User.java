package com.library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name="users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String  password;   //TODO Passwort verschlüsseln, Regeln festlegen



    //TODO Verbindung zu LOAN


    public User(String name, String email, String password){
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

}
