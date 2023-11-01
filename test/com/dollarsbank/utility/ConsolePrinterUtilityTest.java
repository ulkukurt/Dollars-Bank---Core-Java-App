package com.dollarsbank.utility;


import com.dollarsbank.utility.ConsolePrinterUtility;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsolePrinterUtilityTest {

    @Test
    public void testPrintWithBorder() {
        // Redirecting console output to capture printed results
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String message = "Hello World!";
        ConsolePrinterUtility.printWithBorder(message);

        String border = "+".repeat(message.length() + 4);
        String expectedOutput = border + System.lineSeparator() +
                "| " + message + " |" + System.lineSeparator() +
                border + System.lineSeparator();

        assertEquals(expectedOutput, outContent.toString());
    }
}
