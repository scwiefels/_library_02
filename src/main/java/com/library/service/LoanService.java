package com.library.service;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.User;

import java.util.List;

public interface LoanService {

    Loan save(Loan loan);
    Loan cancelLoan(Long loanId);

    List<Loan> findAllLoans();
    Loan returnBook(Long loanId);
    Loan extendLoan(Long loanId, int additionalDays);
    boolean isBookAvailable(Book book);
    List<Loan> findLoansByUser(User user);
    List<Loan> findActiveLoansByUser(User user);
    List<Loan> findLoansByBook(Book book);
}
