package com.dollarsbank.model;


import com.dollarsbank.model.Customer;
import com.dollarsbank.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    private Customer customer;
    private Account account;

    @BeforeEach
    public void setup() {
        account = new Account();
        account.setAccountId("12345");
        account.setBalance(1000.00);
        account.setTransactionHistory(new ArrayList<>());

        customer = new Customer();
    }

    // 1. Initialization Tests
    @Test
    public void testCustomerInitializationWithAttributes() {
        customer.setUsername("testUser");
        customer.setPassword("testPass123");
        customer.setAccount(account);

        assertEquals("testUser", customer.getUsername(), "Username does not match expected value.");
        assertEquals("testPass123", customer.getPassword(), "Password does not match expected value.");
        assertEquals(account, customer.getAccount(), "Account object does not match expected value.");
    }

    // 2. Method Tests

    @Test
    public void testChangePassword() {
        customer.setPassword("newPassword123");
        assertEquals("newPassword123", customer.getPassword(), "Password was not updated correctly.");
    }

    @Test
    public void testGetAccountDetails() {
        customer.setAccount(account);
        Account retrievedAccount = customer.getAccount();
        assertNotNull(retrievedAccount, "Account should not be null.");
        assertEquals(account.getAccountId(), retrievedAccount.getAccountId(), "Account ID retrieved does not match the expected account ID.");
        assertEquals(account.getBalance(), retrievedAccount.getBalance(), "Account balance retrieved does not match the expected balance.");
    }

    // 3. Integration with Account Class

    @Test
    public void testRetrieveAssociatedAccount() {
        customer.setAccount(account);
        Account associatedAccount = customer.getAccount();
        assertNotNull(associatedAccount, "Account associated with customer should not be null.");
        assertEquals(account, associatedAccount, "Account associated with customer does not match the expected account.");
    }

    @Test
    public void testTransactionReflection() {
        ArrayList<String> transactions = new ArrayList<>();
        transactions.add("Deposited $100");
        transactions.add("Withdrew $50");
        account.setTransactionHistory(transactions);
        customer.setAccount(account);

        List<String> customerTransactionHistory = customer.getAccount().getTransactionHistory();

        assertEquals(2, customerTransactionHistory.size(), "Number of transactions doesn't match.");
        assertEquals("Deposited $100", customerTransactionHistory.get(0), "First transaction doesn't match.");
        assertEquals("Withdrew $50", customerTransactionHistory.get(1), "Second transaction doesn't match.");
    }
}
