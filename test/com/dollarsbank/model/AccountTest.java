package com.dollarsbank.test.model;

import com.dollarsbank.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account("A001", 1000.0);
    }

    @Test
    public void testGetAccountId() {
        assertEquals("A001", account.getAccountId(), "Account ID should match the constructor value");
    }

    @Test
    public void testSetAccountId() {
        account.setAccountId("A002");
        assertEquals("A002", account.getAccountId(), "Account ID should be updated to A002");
    }

    @Test
    public void testGetBalance() {
        assertEquals(1000.0, account.getBalance(), "Balance should match the constructor value");
    }

    @Test
    public void testSetBalance() {
        account.setBalance(2000.0);
        assertEquals(2000.0, account.getBalance(), "Balance should be updated to 2000.0");
    }

    @Test
    public void testGetTransactionHistory() {
        List<String> history = account.getTransactionHistory();
        assertEquals(1, history.size(), "Transaction history should have one entry from constructor");
        assertEquals("Initial deposit: $1000.0", history.get(0), "Transaction history should contain the initial deposit message");
    }

    @Test
    public void testSetTransactionHistory() {
        List<String> newHistory = List.of("Deposited $500", "Withdrew $200");
        account.setTransactionHistory(newHistory);
        assertEquals(newHistory, account.getTransactionHistory(), "Transaction history should be updated to the new list");
    }

    @Test
    public void testAddTransaction() {
        account.addTransaction("Deposited $500");
        List<String> history = account.getTransactionHistory();
        assertEquals(2, history.size(), "Transaction history should have two entries");
        assertTrue(history.contains("Deposited $500"), "Transaction history should contain the added transaction detail");
    }

    @Test
    public void testToString() {
        String expectedString = "Account [accountId=A001, balance=1000.0]";
        assertEquals(expectedString, account.toString(), "toString should return the expected string representation");
    }
}
