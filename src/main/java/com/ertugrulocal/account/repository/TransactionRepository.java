package com.ertugrulocal.account.repository;

import com.ertugrulocal.account.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
