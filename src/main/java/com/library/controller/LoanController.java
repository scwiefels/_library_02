package com.library.controller;


import com.library.dto.CreateLoanRequest;
import com.library.model.Loan;
import com.library.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/loans")

/*zuständig für HTTP Handling (Haupt-Endpoints)
    POST /api/loans - Neue Ausleihe
    PUT /api/loans/{id}/return - Rückgabe
    GET /api/loans/overdue - Überfällige Ausleihen*/

public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public List<Loan> findAllLoans(){
        return loanService.findAllLoans();
    }

    @PostMapping
    public ResponseEntity<Loan> save(@Valid @RequestBody CreateLoanRequest request) {
        Loan loan = loanService.save(
                request.getBookId(),
                request.getUserId(),
                request.getLoanPeriodInDays());
        return ResponseEntity.ok(loan);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> findById(@PathVariable Long loanId) {
        return loanService.findById(loanId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
//
//    @PutMapping("/{id}/return")
//    public ResponseEntity<Loan> returnBook(@PathVariable Long id, @RequestBody Loan loan) {
//        return ResponseEntity.ok(loanService.returnBook(id));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Loan> cancelLoan(@PathVariable Long id) {
//        loanService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}
