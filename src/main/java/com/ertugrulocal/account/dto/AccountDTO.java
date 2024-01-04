package com.ertugrulocal.account.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record AccountDTO (
        String id,
        BigDecimal balance,
        LocalDateTime creationDate,
        AccountCustomerDTO customer,
        Set<TransactionDTO> transactions
){}
