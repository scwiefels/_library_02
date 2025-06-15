package com.library.service;

import com.library.model.User;
import com.library.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {         //Constructor Injection statt @Autowired
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {

        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long userId) {

        return userRepository.findById(userId);
    }

    @Override   //TODO update und delete schreiben
    public User update(User user) {

        return null;
    }

    @Override
    public void deleteById(Long userId) {

    }
}
