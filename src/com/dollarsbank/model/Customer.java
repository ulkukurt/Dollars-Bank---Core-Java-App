package com.dollarsbank.model;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
    private String username;
    private String password;
    private Account account;

    // Default constructor
    public Customer() {}

    // Constructor with username, password, and account
    public Customer(String username, String password, Account account) {
        this.username = username;
        this.password = password;
        this.account = account;
    }

    // Constructor with just username and account (useful for the transfer method)
    public Customer(String username, Account account) {
        this.username = username;
        this.account = account;
    }

    // ... (The rest of your getters, setters, and methods remain unchanged)

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(username, customer.username) &&
                Objects.equals(password, customer.password) &&
                Objects.equals(account, customer.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, account);
    }
}
