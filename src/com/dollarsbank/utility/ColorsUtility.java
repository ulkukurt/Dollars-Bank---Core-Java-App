package com.dollarsbank.utility;

public class ColorsUtility {
    public static void printRed(String message) {
        System.out.println(getRedString(message));
    }

    // Added a new method to return the formatted string without printing it
    public static String getRedString(String message) {
        return "\033[0;31m" + message + "\033[0m";
    }
}
