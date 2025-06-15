package com.library.repository;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.LoanStatus;
import com.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {

    List<Loan> findByUser(User user);

    List<Loan> findByBook(Book book);

    List<Loan> findByUserAndStatus(User user, LoanStatus status);

    List<Loan> findByBookAndStatus(Book book, LoanStatus status);

    boolean existsByUserAndBookAndStatus(User user, Book book, LoanStatus status);

    @Query("SELECT l FROM Loan l WHERE l.status = :status AND l.dueDate < :currentDate")
    List<Loan> findOverdueLoans(@Param("status") LoanStatus status,
            @Param("currentDate") LocalDate currentDate);
}
