package com.dollarsbank.application;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.model.Account;
import java.util.Scanner;

public class DollarsBankApplication {

    private static final DollarsBankController controller = new DollarsBankController();
    private static final Account currentUserAccount = new Account("1", 1000.00);  // Sample account with $1000 balance.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            if (!scanner.hasNextInt()) {
                System.out.println("Please select a valid option.");
                scanner.next();  // Consume non-integer input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                // ... (rest of the switch case remains unchanged)
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nDollarsBank Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }
}
