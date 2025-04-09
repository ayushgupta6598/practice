package org.example.multithreading;

import java.util.concurrent.*;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        
        // Put key-value pairs
        map.put("A", 1);
        map.put("B", 2);
        
        // Concurrently read and update values
        map.computeIfAbsent("C", key -> 3);  // Adds "C" with value 3 if not present
        map.computeIfPresent("A", (key, val) -> val + 1);  // Increments value for "A"
        
        // Display the map contents
        System.out.println("ConcurrentMap: " + map);
    }
}
