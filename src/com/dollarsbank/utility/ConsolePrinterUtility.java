package com.dollarsbank.utility;

public class ConsolePrinterUtility {

    public static void printWithBorder(String message) {
        String border = "+".repeat(message.length() + 4); // +4 for the spaces and borders on both sides
        System.out.println(border);
        System.out.println("| " + message + " |");
        System.out.println(border);
    }
}
