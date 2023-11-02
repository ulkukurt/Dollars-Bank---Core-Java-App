package com.dollarsbank.test;

import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.FileStorageUtility;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileStorageUtilityTest {

    private final String testFilePath = "test_customers.txt";
    private List<Customer> sampleCustomers;

    @BeforeEach
    public void setUp() {
        sampleCustomers = new ArrayList<>();
        Customer customer1 = new Customer();
        // TODO: Set other attributes of customer1 as needed
        sampleCustomers.add(customer1);

        Customer customer2 = new Customer();
        // TODO: Set other attributes of customer2 as needed
        sampleCustomers.add(customer2);

        FileStorageUtility.writeToFile(sampleCustomers, testFilePath);

    }

    @Test
    public void testWriteAndReadFromFile() {
        List<Customer> retrievedCustomers = FileStorageUtility.readFromFile(testFilePath);

        assertEquals(sampleCustomers.size(), retrievedCustomers.size(), "The number of customers retrieved should match the number written.");

        // TODO: Add more assertions to verify the content of the customers, not just the count
    }

    @AfterEach
    public void tearDown() {
        // Delete the test file after the test completes
        File file = new File(testFilePath);
        if (file.exists() && !file.isDirectory()) {
            boolean isDeleted = file.delete();
            if (!isDeleted) {
                System.out.println("Failed to delete test file: " + testFilePath);
            }
        } else {
            System.out.println("Test file " + testFilePath + " does not exist or is a directory.");
        }
    }
}
