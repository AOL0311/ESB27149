package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A map that allows multiple values per key.
 * Calling put() with the same key appends the value to the existing list
 * rather than overwriting it.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public class MultiValueMap<K, V> {

    private final Map<K, List<V>> store = new HashMap<>();

    /**
     * Adds the given value to the list associated with the key.
     * If the key does not exist yet, a new list is created.
     */
    public void put(K key, V value) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    /**
     * Returns an unmodifiable view of all values associated with the key,
     * or an empty list if the key does not exist.
     */
    public List<V> get(K key) {
        return Collections.unmodifiableList(store.getOrDefault(key, Collections.emptyList()));
    }

    /**
     * Returns true if the map contains the given key.
     */
    public boolean containsKey(K key) {
        return store.containsKey(key);
    }

    /**
     * Removes all values for the given key.
     */
    public void remove(K key) {
        store.remove(key);
    }

    /**
     * Returns the number of distinct keys.
     */
    public int size() {
        return store.size();
    }

    /**
     * Returns true if the map contains no keys.
     */
    public boolean isEmpty() {
        return store.isEmpty();
    }

    /**
     * Returns all keys in the map.
     */
    public Set<K> keySet() {
        return Collections.unmodifiableSet(store.keySet());
    }

    /**
     * Removes all entries from the map.
     */
    public void clear() {
        store.clear();
    }

    @Override
    public String toString() {
        return store.toString();
    }
}
