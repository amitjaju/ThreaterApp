package com.test.moviebooking;


import org.example.moviebooking.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @Test
    public void testMain() {
        // Simulate user input for booking tickets
        String userInput = "1\nA1,B1,C1\nNo\n";
        provideInput(userInput);

        // Run the main method
        Main.main(new String[0]);

        // Check the output
        String output = getOutput();
        assertTrue(output.contains("Successfully Booked - Show 1"));
        assertTrue(output.contains("Subtotal: Rs. 840.0"));
        assertTrue(output.contains("Service Tax @14%: Rs. 117.6"));
        assertTrue(output.contains("Swachh Bharat Cess @0.5%: Rs. 4.2"));
        assertTrue(output.contains("Krishi Kalyan Cess @0.5%: Rs. 4.2"));
        assertTrue(output.contains("Total: Rs. 966.0"));
    }
}


