package com.dollarsbank.test.utility;

import com.dollarsbank.utility.ColorsUtility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorsUtilityTest {
    @Test
    public void testGetRedString() {
        String testMessage = "Hello, World!";
        String expected = "\033[0;31m" + testMessage + "\033[0m";
        String result = ColorsUtility.getRedString(testMessage);

        assertEquals(expected, result, "The message should be wrapped with red color codes");
    }
}
