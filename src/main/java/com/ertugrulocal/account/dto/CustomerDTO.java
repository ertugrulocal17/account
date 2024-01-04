package com.ertugrulocal.account.dto;

import java.util.Set;

public record CustomerDTO(
        String id,
        String name,
        String surname,
        Set<CustomerAccountDTO> accounts
) {
}
