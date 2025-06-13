package com.library.controller;


import com.library.model.Loan;
import com.library.model.User;
import com.library.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
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
    @ResponseStatus(HttpStatus.CREATED)    // 201 no content als Basis für erfolgreiche Erstellung
    public Loan save(@RequestBody Loan loan) {
        System.out.println("Save loan: " + loan);
        return loanService.save(loan);
    }
}
