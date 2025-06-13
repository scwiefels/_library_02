package com.library.service;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.LoanStatus;
import com.library.model.User;
import com.library.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor

public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    private static final int DEFAULT_LOAN_PERIOD_DAYS = 14;
    private static final int MAX_LOANS_PER_USER = 5;
    private static final int MAX_EXTENSION_DAYS = 7;



    @Override   //FIXME Validierung
    public Loan save(Loan loan){
        return loanRepository.save(loan);

//    public Loan save(User user, Book book, int loanPeriodDays) {
//        log.info("Erstelle neue Ausleihe für " +
//                "Benutzer {} und Buch {}", user.getId(), book.getId());
//
//        Loan loan = Loan.builder()
//                .user(user)
//                .book(book)
//                .loanDate(LocalDate.now())
//                .dueDate(LocalDate.now().plusDays(loanPeriodDays))
//                .status(LoanStatus.ACTIVE)
//                .build();
//
//        Loan savedLoan = loanRepository.save(loan);
//        log.info("Ausleihe erfolgreich erstellt mit ID: {}", savedLoan.getId());
//
//        return savedLoan;
    }

    @Override
    public Loan cancelLoan(Long loanId) {
        return null;
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
