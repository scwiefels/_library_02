package com.library.controller;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.User;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")// localhost:8080/api/users
public class UserController {


    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    public ResponseEntity<User> findById(@PathVariable Long userId) {
        return userService.findById(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
//    @GetMapping("{/userId}")
//    public Optional<User> findById(@PathVariable("userId") Long userId){
//        return userService.findById(userId);
//    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)    // 201 no content als Basis für erfolgreiche Erstellung
    public User save(@RequestBody User user) {
        System.out.println("Save user: " + user);
        return userService.save(user);
    }
}
