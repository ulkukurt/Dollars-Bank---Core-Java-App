package com.dollarsbank.utility;

import java.io.*;
import java.util.List;
import com.dollarsbank.model.Customer;

public class FileStorageUtility {

    public static void writeToFile(List<Customer> customers, String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(customers);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Customer> readFromFile(String filename) {
        List<Customer> customers = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            customers = (List<Customer>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
        }
        return customers;
    }
}
