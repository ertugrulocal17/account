package com.ertugrulocal.account.model;

import com.ertugrulocal.account.service.AccountService;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id = "";
    private BigDecimal balance = BigDecimal.ZERO;
    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private Set<Transaction> transaction = new HashSet<>();
    public Account(){}
    public Account(BigDecimal balance, LocalDateTime creationDate, Customer customer) {
        this.id = "";
        this.balance = balance;
        this.creationDate = creationDate;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<Transaction> transaction) {
        this.transaction = transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(balance, account.balance) && Objects.equals(creationDate, account.creationDate) && Objects.equals(customer, account.customer) && Objects.equals(transaction, account.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, creationDate, customer);
    }
}
