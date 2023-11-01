package com.dollarsbank.controller;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;

public class DollarsBankController {

    public void deposit(double amount, Account account) {
        if (amount > 0) {
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            account.getTransactionHistory().add("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdrawal(double amount, Account account) {
        double currentBalance = account.getBalance();
        if (amount > 0 && currentBalance >= amount) {
            double newBalance = currentBalance - amount;
            account.setBalance(newBalance);
            account.getTransactionHistory().add("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance!");
        }
    }

    public void transfer(double amount, Customer fromCustomer, Customer toCustomer) {
        double currentBalanceFrom = fromCustomer.getAccount().getBalance();
        if (amount > 0 && currentBalanceFrom >= amount) {
            // Withdrawal from the source account
            withdrawal(amount, fromCustomer.getAccount());

            // Deposit to the target account
            deposit(amount, toCustomer.getAccount());

            // Update transaction history for both accounts
            fromCustomer.getAccount().getTransactionHistory().add("Transferred: $" + amount + " to " + toCustomer.getAccount().getAccountId());
            toCustomer.getAccount().getTransactionHistory().add("Received: $" + amount + " from " + fromCustomer.getAccount().getAccountId());
        } else {
            System.out.println("Invalid transfer amount or insufficient balance in the source account!");
        }
    }
}
