package com.dollarsbank.utility;

public class ColorsUtility {
    public static void printRed(String message) {
        System.out.println("\033[0;31m" + message + "\033[0m");
    }
}

