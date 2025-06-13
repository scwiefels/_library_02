package com.library.controller;

import com.library.model.User;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
    @RequestMapping("/api/user")// localhost:8080/api/books

    public class UserController {
        @Autowired
        private UserService userService;

        @GetMapping
        public List<User> findAll(){
            return userService.findAll();
        }

        @GetMapping
        public Optional<User> findById(Long id) {
            return userService.findById(id);
        }
}
