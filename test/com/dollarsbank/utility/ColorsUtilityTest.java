package com.dollarsbank.utility;


import com.dollarsbank.utility.ColorsUtility;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorsUtilityTest {

    @Test
    public void testPrintRed() {
        // Redirecting console output to capture printed results
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String message = "This is a test message.";
        ColorsUtility.printRed(message);

        // "\033[0;31m" is the ANSI code for red, and "\033[0m" resets the color.
        String expectedOutput = "\033[0;31m" + message + "\033[0m" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}
