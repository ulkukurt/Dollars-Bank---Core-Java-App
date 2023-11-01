package com.dollarsbank.model;

import com.dollarsbank.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account("A12345", 1000.0); // Create an account with initial balance of $1000
    }

    @Test
    public void testInitialBalance() {
        assertEquals(1000.0, account.getBalance(), 0.001);
    }

    @Test
    public void testDeposit() {
        account.setBalance(account.getBalance() + 500.0); // Deposit $500
        assertEquals(1500.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawal() {
        account.setBalance(account.getBalance() - 300.0); // Withdraw $300
        assertEquals(700.0, account.getBalance(), 0.001);
    }

    @Test
    public void testTransactionHistory() {
        account.addTransaction("Deposited: $500");
        account.addTransaction("Withdrew: $300");

        assertEquals(3, account.getTransactionHistory().size());
        assertEquals("Initial deposit: $1000.0", account.getTransactionHistory().get(0));
        assertEquals("Deposited: $500", account.getTransactionHistory().get(1));
        assertEquals("Withdrew: $300", account.getTransactionHistory().get(2));
    }

    @Test
    public void testAccountId() {
        account.setAccountId("A67890");
        assertEquals("A67890", account.getAccountId());
    }
}
