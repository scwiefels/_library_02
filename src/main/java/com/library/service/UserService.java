package com.library.service;


import com.library.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);
    List<User> findAll();
    Optional<User> findById(Long userId);
    User update(User user);
    void deleteById(Long userId);
}
