package com.library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name="users")
@Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String userName;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String  password;   //TODO Passwort verschlüsseln, Regeln festlegen

    @ElementCollection
    @CollectionTable(name = "user_borrowed_books", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "book_id")
    @Builder.Default
    private List<Long> borrowedBookIds = new ArrayList<>();

    //TODO Verbindung zu LOAN


    public User(String userName, String email, String password){
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.borrowedBookIds = new ArrayList<>();
    }

}
