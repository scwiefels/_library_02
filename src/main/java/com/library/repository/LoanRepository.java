package com.library.repository;

import com.library.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan,Long> {

    List<Loan> findByUserId(Long userId);
    List<Loan> findByBookId(Long Id);
    List<Loan> findByReturned(Boolean returned);
    List<Loan> findByUserIdAndReturned(Long userId,Boolean returned);
}
