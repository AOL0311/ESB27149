package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testDivideNormal() {
        double expected = 1.0 / 3.0;
        double actual = App.divideAndRound(1, 3,2);
        
        assertEquals(expected, actual, 0.01, "Counting result not match expected.");
    }

    @Test
    void testDivideExact() {
        assertEquals(2.0, App.divideAndRound(6, 3, 2), "Counting result not match expected.");
    }

    @Test
    void testDivideByZero() {
        double result = App.divideAndRound(1, 0, 2);
        assertTrue(Double.isInfinite(result), "Counting result not match expected.");
    }
}