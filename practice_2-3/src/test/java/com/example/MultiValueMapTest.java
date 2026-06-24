package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultiValueMapTest {

    private MultiValueMap<String, String> map;

    @BeforeEach
    void setUp() {
        map = new MultiValueMap<>();
    }

    @Test
    void testPutAndGetSingleValue() {
        map.put("color", "red");
        List<String> values = map.get("color");
        assertEquals(1, values.size());
        assertEquals("red", values.get(0));
    }

    @Test
    void testPutSameKeyAppendsValues() {
        map.put("color", "red");
        map.put("color", "green");
        map.put("color", "blue");

        List<String> values = map.get("color");
        assertEquals(3, values.size());
        assertEquals(List.of("red", "green", "blue"), values);
    }

    @Test
    void testPutDifferentKeysAreIndependent() {
        map.put("color", "red");
        map.put("size", "large");
        map.put("color", "blue");

        assertEquals(List.of("red", "blue"), map.get("color"));
        assertEquals(List.of("large"),       map.get("size"));
    }

    @Test
    void testGetMissingKeyReturnsEmptyList() {
        List<String> values = map.get("nonexistent");
        assertNotNull(values);
        assertTrue(values.isEmpty());
    }

    @Test
    void testGetReturnsUnmodifiableList() {
        map.put("color", "red");
        List<String> values = map.get("color");
        assertThrows(UnsupportedOperationException.class, () -> values.add("blue"));
    }

    @Test
    void testContainsKey() {
        assertFalse(map.containsKey("color"));
        map.put("color", "red");
        assertTrue(map.containsKey("color"));
    }

    @Test
    void testRemove() {
        map.put("color", "red");
        map.remove("color");
        assertFalse(map.containsKey("color"));
        assertTrue(map.get("color").isEmpty());
    }

    @Test
    void testSize() {
        assertEquals(0, map.size());
        map.put("color", "red");
        map.put("color", "blue");
        map.put("size", "large");
        assertEquals(2, map.size()); // 2 distinct keys
    }

    @Test
    void testClear() {
        map.put("color", "red");
        map.put("size", "large");
        map.clear();
        assertTrue(map.isEmpty());
    }

    @Test
    void testGenericIntegerValues() {
        MultiValueMap<String, Integer> scores = new MultiValueMap<>();
        scores.put("alice", 90);
        scores.put("alice", 85);
        scores.put("bob", 70);

        assertEquals(List.of(90, 85), scores.get("alice"));
        assertEquals(List.of(70),     scores.get("bob"));
    }

    @Test
    void testGenericIntegerKeys() {
        MultiValueMap<Integer, String> byCode = new MultiValueMap<>();
        byCode.put(1, "one");
        byCode.put(1, "uno");
        byCode.put(2, "two");

        assertEquals(List.of("one", "uno"), byCode.get(1));
        assertEquals(List.of("two"),        byCode.get(2));
    }
}
