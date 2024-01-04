package com.ertugrulocal.account.repository;

import com.ertugrulocal.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
