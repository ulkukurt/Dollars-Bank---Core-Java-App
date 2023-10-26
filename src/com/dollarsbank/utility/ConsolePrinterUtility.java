package com.dollarsbank.utility;

public class ConsolePrinterUtility {
    public static void printWithBorder(String message) {
        int length = message.length();
        String border = "+".repeat(length + 4); // The 4 accounts for spaces and "+" on both sides
        System.out.println(border);
        System.out.println("| " + message + " |");
        System.out.println(border);
    }
}
