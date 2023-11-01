package com.dollarsbank.utility;

// ... (other imports)

public class FileStorageUtilityTest {

    private final String testFilePath = "test_customers.txt";

    @BeforeEach
    public void setUp() {
        // Declare the sampleCustomers list locally
        List<Customer> sampleCustomers = new ArrayList<>();
        Customer customer1 = new Customer();
        // ... (Set other attributes of customer1 as needed)
        sampleCustomers.add(customer1);

        Customer customer2 = new Customer();
        // ... (Set other attributes of customer2 as needed)
        sampleCustomers.add(customer2);
    }

    @Test
    public void testWriteAndReadFromFile() {
        // ... (rest of the method remains unchanged)
    }

    @AfterEach
    public void tearDown() {
        // Delete the test file after the test completes
        File file = new File(testFilePath);
        if (file.exists()) {
            boolean isDeleted = file.delete();
            if (!isDeleted) {
                System.out.println("Failed to delete test file: " + testFilePath);
            }
        }
    }
}
