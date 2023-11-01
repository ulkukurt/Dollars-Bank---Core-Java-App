package com.dollarsbank.application;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DollarsBankApplicationTest {

    private DollarsBankController controller;
    private Account testAccount;

    @BeforeEach
    public void setup() {
        controller = new DollarsBankController();
        testAccount = new Account("1", 1000.00);  // Adjusted this line to use String for accountId
    }

    @Test
    public void testDeposit() {
        controller.deposit(100.00, testAccount);
        assertEquals(1100.00, testAccount.getBalance());
    }

    @Test
    public void testWithdrawal() {
        controller.withdrawal(100.00, testAccount);
        assertEquals(900.00, testAccount.getBalance());
    }

    @Test
    public void testInvalidWithdrawal() {
        controller.withdrawal(1100.00, testAccount);
        assertEquals(1000.00, testAccount.getBalance());  // Balance should remain unchanged
    }

    // Add any other necessary test methods

}
