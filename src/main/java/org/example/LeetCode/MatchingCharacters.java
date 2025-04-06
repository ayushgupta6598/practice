package org.example.LeetCode;


import java.util.*;

public class MatchingCharacters {
    public static List<String> findMatchingCharacters(List<String> names) {
        if (names == null || names.size() == 0) {
            return Collections.emptyList();
        }

        // Initialize frequency map with the first name
        Map<Character, Integer> charCount = new HashMap<>();
        String firstName = names.get(0);

        for (char c : firstName.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Update frequency map for each subsequent name
        for (int i = 1; i < names.size(); i++) {
            String name = names.get(i);
            Map<Character, Integer> tempCount = new HashMap<>();

            for (char c : name.toCharArray()) {
                if (charCount.containsKey(c)) {
                    tempCount.put(c, tempCount.getOrDefault(c, 0) + 1);
                }
            }

            // Update charCount with minimum counts from tempCount
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                char c = entry.getKey();
                charCount.put(c, Math.min(entry.getValue(), tempCount.getOrDefault(c, 0)));
            }
        }

        // Build result list
        List<String> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                result.add(String.valueOf(c));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> names1 = Arrays.asList("nellie", "leslie", "stella");
        System.out.println("Matching Characters: " + findMatchingCharacters(names1)); // Output: [e, l, l, 1]

        List<String> names2 = Arrays.asList("cool", "lock", "cook");
        System.out.println("Matching Characters: " + findMatchingCharacters(names2)); // Output: [c, o]
    }
}