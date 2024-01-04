package com.ertugrulocal.account.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record CreateAccountRequest (
        @NotBlank()
        String customerId,
        @Min(0)
        BigDecimal initialCredit
){}
