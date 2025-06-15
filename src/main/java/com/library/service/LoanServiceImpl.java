package com.library.service;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.LoanStatus;
import com.library.model.User;
import com.library.repository.BookRepository;
import com.library.repository.LoanRepository;
import com.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor

public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

   //Konstanten für die Geschäftslogik
    private static final int DEFAULT_LOAN_PERIOD_DAYS = 14;
    private static final int MAX_LOANS_PER_USER = 5;
    private static final int MAX_EXTENSION_DAYS = 7;



    @Override
    public Loan save(Long userId, Long bookId, int loanPeriodDays){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        Loan loan = Loan.builder()
                .user(user)
                .book(book)
                .loanDate(LocalDate.now())
                .dueDate(LocalDate.now().plusDays(loanPeriodDays))
                .status(LoanStatus.ACTIVE)
                .build();

        return loanRepository.save(loan);

    }

    @Override
    public Loan delete(Long loanId) {
        return null;
    }

    @Override
    @Transactional (readOnly = true)
    public Optional<Loan> findById(Long loanId) {
        return loanRepository.findById(loanId);
    }

    @Override
    public List<Loan> findOverdueLoans() {
        return List.of();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Loan> findAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Loan returnBook(Long loanId) {
        return null;
    }

    @Override
    public Loan extendLoan(Long loanId, int additionalDays) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isBookAvailable(Book book) {
        List<Loan> activeLoans = loanRepository.findByBookAndStatus(book, LoanStatus.ACTIVE);
        return activeLoans.isEmpty();
    }

    @Override
    public List<Loan> findLoansByUser(User user) {
        return List.of();
    }

    @Override
    public List<Loan> findActiveLoansByUser(User user) {
        return List.of();
    }

    @Override
    public List<Loan> findLoansByBook(Book book) {
        return List.of();
    }
}
