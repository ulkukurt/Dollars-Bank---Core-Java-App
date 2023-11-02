package com.dollarsbank.application;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.model.Account;
import java.util.Scanner;

public class DollarsBankApplication {

    private static final DollarsBankController controller = new DollarsBankController();
    private static final Account currentUserAccount = new Account("1", 1000.00);  // Sample account with $1000 balance.

    public static void runApp(Scanner scanner) {
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
                case 1: // Deposit
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    controller.deposit(depositAmount, currentUserAccount);
                    System.out.println("Deposited: " + depositAmount);
                    break;
                case 2:  // Withdraw
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    controller.withdrawal(withdrawAmount, currentUserAccount);
                    System.out.println("Withdrew: " + withdrawAmount);
                    break;
                case 3:  // Check Balance
                    System.out.println("Current Balance: $" + currentUserAccount.getBalance());
                    break;
                case 4: // Exit
                    System.out.println("Thank you for using DollarsBank!");
                    return; // Exiting the application
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        runApp(scanner);
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
