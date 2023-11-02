package com.dollarsbank.application;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class DollarsBankApplicationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void testDepositOption() {
        try {
            String simulatedUserInput = "1\n50.5\n4\n"; // '1' for deposit, '50.5' as deposit amount, '4' to exit
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
            Scanner scanner = new Scanner(System.in);

            DollarsBankApplication.runApp(scanner);

            assertTrue(outContent.toString().contains("Deposited: 50.5"));
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testWithdrawOption() {
        try {
            String simulatedUserInput = "2\n20.5\n4\n"; // '2' for withdrawal, '20.5' as withdraw amount, '4' to exit
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
            Scanner scanner = new Scanner(System.in);

            DollarsBankApplication.runApp(scanner);

            assertTrue(outContent.toString().contains("Withdrew: 20.5"));
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testCheckBalanceOption() {
        try {
            String simulatedUserInput = "3\n4\n"; // '3' for checking balance, '4' to exit
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
            Scanner scanner = new Scanner(System.in);

            DollarsBankApplication.runApp(scanner);

            assertTrue(outContent.toString().contains("Current Balance: $1000.0")); // Initial balance was $1000.00
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown: " + e.getMessage());
        }
    }

    // You can add more test methods as needed
}
