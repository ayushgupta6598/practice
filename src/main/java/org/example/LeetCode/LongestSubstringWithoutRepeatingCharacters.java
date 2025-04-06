package org.example.LeetCode;


import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the map, move left pointer
            if (map.containsKey(s.charAt(right))) {
                left =  map.get(s.charAt(right)) + 1;
            }
            // Update the map with the current character's latest index
            map.put(s.charAt(right), right);
            // Calculate the maximum length
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

        // Test case example
        String input = "abba";
        int result = solution.lengthOfLongestSubstring(input);

        System.out.println("Length of longest substring without repeating characters: " + result);
    }
}
