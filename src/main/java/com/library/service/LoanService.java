package com.library.service;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.User;

import java.util.List;
import java.util.Optional;

public interface LoanService {

    Loan save(Long userId, Long bookId, int loanPeriodDays);
    Loan delete(Long loanId);
    Optional<Loan> findById(Long loanId);
    List<Loan> findOverdueLoans();
    List<Loan> findAllLoans();

    Loan returnBook(Long loanId);
    Loan extendLoan(Long loanId, int additionalDays);

    boolean isBookAvailable(Book book);

    List<Loan> findLoansByUser(User user);
    List<Loan> findActiveLoansByUser(User user);

    List<Loan> findLoansByBook(Book book);

}
