package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testDivideNormal() {
        double expected = 0.33;
        double actual = App.divideAndRound(1, 3,2);
        
        assertEquals(expected, actual, 0.0001, "Counting result not match expected.");
    }

    @Test
    void testDivideExact() {
        assertEquals(2.0, App.divideAndRound(6, 3, 2), "Counting result not match expected.");
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            App.divideAndRound(1, 0, 2);
        }, "Expected ArithmeticException for division by zero.");
    }
}