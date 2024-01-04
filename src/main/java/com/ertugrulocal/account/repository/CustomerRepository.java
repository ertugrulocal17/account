package com.ertugrulocal.account.repository;

import com.ertugrulocal.account.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
