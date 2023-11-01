package com.dollarsbank.controller;
import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DollarsBankControllerTest {

    private DollarsBankController controller;
    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    public void setup() {
        controller = new DollarsBankController();

        customer1 = new Customer();
        Account account1 = new Account();
        account1.setAccountId("A001");
        account1.setBalance(1000);
        customer1.setAccount(account1);

        customer2 = new Customer();
        Account account2 = new Account();
        account2.setAccountId("A002");
        account2.setBalance(500);
        customer2.setAccount(account2);
    }

    @Test
    public void testDepositWithTransactionHistory() {
        double depositAmount = 200;
        double initialBalance = customer1.getAccount().getBalance();
        controller.deposit(depositAmount, customer1.getAccount());

        assertEquals(initialBalance + depositAmount, customer1.getAccount().getBalance());

        // Check if the transaction history is updated
        assertTrue(customer1.getAccount().getTransactionHistory().contains("Deposited: $" + depositAmount));
    }

    @Test
    public void testWithdrawalWithTransactionHistory() {
        double withdrawalAmount = 100;
        double initialBalance = customer1.getAccount().getBalance();
        controller.withdrawal(withdrawalAmount, customer1.getAccount());

        assertEquals(initialBalance - withdrawalAmount, customer1.getAccount().getBalance());

        // Check if the transaction history is updated
        assertTrue(customer1.getAccount().getTransactionHistory().contains("Withdrew: $" + withdrawalAmount));
    }

    @Test
    public void testTransferWithTransactionHistory() {
        double transferAmount = 100;
        double initialBalanceCustomer1 = customer1.getAccount().getBalance();
        double initialBalanceCustomer2 = customer2.getAccount().getBalance();

        controller.transfer(transferAmount, customer1, customer2);

        assertEquals(initialBalanceCustomer1 - transferAmount, customer1.getAccount().getBalance());
        assertEquals(initialBalanceCustomer2 + transferAmount, customer2.getAccount().getBalance());

        // Check if the transaction histories are updated
        assertTrue(customer1.getAccount().getTransactionHistory().contains("Transferred: $" + transferAmount + " to " + customer2.getAccount().getAccountId()));
        assertTrue(customer2.getAccount().getTransactionHistory().contains("Received: $" + transferAmount + " from " + customer1.getAccount().getAccountId()));
    }
}

