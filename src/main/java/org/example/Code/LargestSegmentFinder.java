package org.example.Code;

public class LargestSegmentFinder {

    public static String findLargestSegment(String input) {
        if (input == null || input.length() < 2) {
            return ""; // No segment can be found if the string is null or too short
        }

        String largestSegment = "";
        int maxLength = 0;
        int currentLength = 1; // Start with 1 because a segment of at least 1 character is required

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    largestSegment = input.substring(i - currentLength, i);
                }
                currentLength = 1; // Reset for the new character segment
            }
        }

        // Final check for the last segment
        if (currentLength > maxLength) {
            largestSegment = input.substring(input.length() - currentLength);
        }

        // Ensure the segment is more than 1 character long
        return largestSegment.length() > 1 ? largestSegment : "";
    }

    public static void main(String[] args) {
        String input = "aabcccc";
        String result = findLargestSegment(input);
        System.out.println(result); // Expected output: "aa"
    }
}

