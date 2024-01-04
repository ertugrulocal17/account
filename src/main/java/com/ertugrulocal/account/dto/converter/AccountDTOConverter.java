package com.ertugrulocal.account.dto.converter;

import com.ertugrulocal.account.dto.AccountDTO;
import com.ertugrulocal.account.dto.TransactionDTO;
import com.ertugrulocal.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AccountDTOConverter {
    private final CustomerDTOConverter customerDTOConverter;
    private final TransactionDTOConverter transactionDTOConverter;

    public AccountDTOConverter(CustomerDTOConverter customerDTOConverter, TransactionDTOConverter transactionDTOConverter) {
        this.customerDTOConverter = customerDTOConverter;
        this.transactionDTOConverter = transactionDTOConverter;
    }


    public AccountDTO convert(Account from){
        return new AccountDTO(
                from.getId(),
                from.getBalance(),
                from.getCreationDate(),
                customerDTOConverter.convertToAccountCustomer(from.getCustomer()),
                from.getTransaction().stream().map(transactionDTOConverter::convert).collect(Collectors.toSet()));
    }
}
