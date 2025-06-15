package com.library.repository;

import com.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByNameContainingIgnoreCase(String userName);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findUsersWithBorrowedBooks();
}
