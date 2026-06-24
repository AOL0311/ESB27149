package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testAllLowercase() {
        assertEquals("meat", App.toSnakeCase("meat"));
    }

    @Test
    void testSimpleCamel() {
        assertEquals("sea_food", App.toSnakeCase("seaFood"));
    }

    @Test
    void testAcronymInMiddle() {
        assertEquals("my_usd_money", App.toSnakeCase("myUSDMoney"));
    }

    @Test
    void testLeadingAcronym() {
        assertEquals("usd_rate", App.toSnakeCase("USDRate"));
    }

    @Test
    void testSingleWord() {
        assertEquals("hello", App.toSnakeCase("hello"));
    }

    @Test
    void testAllUppercase() {
        assertEquals("usd", App.toSnakeCase("USD"));
    }

    @Test
    void testMultipleCamelHumps() {
        assertEquals("my_camel_case_string", App.toSnakeCase("myCamelCaseString"));
    }

    @Test
    void testNullInput() {
        assertNull(App.toSnakeCase(null));
    }

    @Test
    void testEmptyInput() {
        assertEquals("", App.toSnakeCase(""));
    }
}