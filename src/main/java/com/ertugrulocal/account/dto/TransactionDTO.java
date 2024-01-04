package com.ertugrulocal.account.dto;

import com.ertugrulocal.account.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDTO(
        String id,
        TransactionType transactionType,
        BigDecimal amount,
        LocalDateTime transactionDate

) {

}
