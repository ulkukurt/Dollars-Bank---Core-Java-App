package com.dollarsbank.controller;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DollarsBankControllerTest {

    private DollarsBankController controller;
    private Account accountA;
    private Account accountB;
    private Customer customerA;
    private Customer customerB;

    @BeforeEach
    public void setUp() {
        controller = new DollarsBankController();
        accountA = new Account("1", 1000.0);  // Sample account with $1000 balance.
        accountB = new Account("2", 500.0);   // Another sample account with $500 balance.
        customerA = new Customer("John", accountA); // Sample customer
        customerB = new Customer("Doe", accountB);  // Another sample customer
    }

    @Test
    public void testDeposit() {
        controller.deposit(100.0, accountA);
        assertEquals(1100.0, accountA.getBalance());
        assertTrue(accountA.getTransactionHistory().contains("Deposited: $100.0"));
    }

    @Test
    public void testWithdrawal() {
        controller.withdrawal(200.0, accountA);
        assertEquals(800.0, accountA.getBalance());
        assertTrue(accountA.getTransactionHistory().contains("Withdrew: $200.0"));
    }

    @Test
    public void testTransfer() {
        controller.transfer(300.0, customerA, customerB);
        assertEquals(700.0, accountA.getBalance());
        assertEquals(800.0, accountB.getBalance());
        assertTrue(accountA.getTransactionHistory().contains("Transferred: $300.0 to 2"));
        assertTrue(accountB.getTransactionHistory().contains("Received: $300.0 from 1"));
    }
}
