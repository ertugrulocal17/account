package com.ertugrulocal.account.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record CustomerAccountDTO (
        String id,
        BigDecimal balance,
        Set<TransactionDTO> transactions,
        LocalDateTime creationDate
){

}
