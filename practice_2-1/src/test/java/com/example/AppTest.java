package com.example;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testMd5Hello() {
        String expected = DigestUtils.md5Hex("hello");
        assertEquals("5d41402abc4b2a76b9719d911017c592", expected);
    }

    @Test
    void testMd5World() {
        String expected = DigestUtils.md5Hex("world");
        assertEquals("7d793037a0760186574b0282f2f435e7", expected);
    }

    @Test
    void testMd5EmptyString() {
        String expected = DigestUtils.md5Hex("");
        assertEquals("d41d8cd98f00b204e9800998ecf8427e", expected);
    }

    @Test
    void testMd5IsLowercase() {
        String result = DigestUtils.md5Hex("test");
        assertEquals(result, result.toLowerCase(), "MD5 output should be lowercase hex.");
    }

    @Test
    void testMd5Length() {
        String result = DigestUtils.md5Hex("anything");
        assertEquals(32, result.length(), "MD5 hex string should be 32 characters.");
    }
}