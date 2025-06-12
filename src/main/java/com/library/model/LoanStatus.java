package com.library.model;

import lombok.Getter;

@Getter
public enum LoanStatus {

    ACTIVE("Aktiv"),
    RETURNED("Zurückgegeben"),
    CANCELLED("Storniert");

    private final String displayName;

    LoanStatus(String displayName) {
        this.displayName = displayName;
    }

}
