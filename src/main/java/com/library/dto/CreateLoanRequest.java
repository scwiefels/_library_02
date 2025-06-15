package com.library.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;




    @Data
    public class CreateLoanRequest {
        @NotNull
        private Long bookId;

        @NotNull
        private Long userId;

        @Positive
        private int loanPeriodInDays;
}
