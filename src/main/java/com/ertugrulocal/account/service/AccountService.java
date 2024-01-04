package com.ertugrulocal.account.service;

import com.ertugrulocal.account.dto.AccountDTO;
import com.ertugrulocal.account.dto.CreateAccountRequest;
import com.ertugrulocal.account.dto.converter.AccountDTOConverter;
import com.ertugrulocal.account.model.Account;
import com.ertugrulocal.account.model.Customer;
import com.ertugrulocal.account.model.Transaction;
import com.ertugrulocal.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDTOConverter converter;


    public AccountService(
            AccountRepository accountRepository,
            CustomerService customerService,
            AccountDTOConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;

        this.converter = converter;

    }

    public AccountDTO createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.customerId());
        Account account = new Account(createAccountRequest.initialCredit(), LocalDateTime.now(), customer);

        if (createAccountRequest.initialCredit().compareTo(BigDecimal.ZERO) > 0) {
//            Transaction transaction = transactionService.initiateMoney(account,createAccountRequest.initialCredit());
            Transaction transaction = new Transaction(createAccountRequest.initialCredit(), account);
            account.getTransaction().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }


}
