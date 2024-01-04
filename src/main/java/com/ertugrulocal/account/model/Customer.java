package com.ertugrulocal.account.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;
    private String surname;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Account> accounts = new HashSet<>();

    public Customer(){}

    public Customer(String id, String name, String surname, Set<Account> accounts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.accounts = accounts;
    }

    public Customer(String name, String surname) {
        this.id = "";
        this.name = name;
        this.surname = surname;
        this.accounts = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) && Objects.equals(accounts, customer.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }
}
