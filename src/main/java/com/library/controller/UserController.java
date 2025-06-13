package com.library.controller;

import com.library.model.Book;
import com.library.model.User;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/user")// localhost:8080/api/books
public class UserController {


    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping
    public Optional<User> findById(Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)    // 201 no content als Basis für erfolgreiche Erstellung
    public User save(@RequestBody User user) {
        System.out.println("Save user: " + user);
        return userService.save(user);
    }
}
