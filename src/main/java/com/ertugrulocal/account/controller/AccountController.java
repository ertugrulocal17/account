package com.ertugrulocal.account.controller;

import com.ertugrulocal.account.dto.AccountDTO;
import com.ertugrulocal.account.dto.CreateAccountRequest;
import com.ertugrulocal.account.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody @Valid CreateAccountRequest request){
        return ResponseEntity.ok(accountService.createAccount(request));
    }
}
