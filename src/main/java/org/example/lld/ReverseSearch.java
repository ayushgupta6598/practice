package org.example.lld;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> commandHistory = new ArrayList<>();
        
        System.out.println("Enter commands (type 'exit' to quit, 'search <query>' to reverse search):");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.startsWith("search ")) {
                String query = input.substring(7);  // Extract the search term
                String result = reverseSearch(commandHistory, query);

                if (result != null) {
                    System.out.println("Found: " + result);
                } else {
                    System.out.println("No matching command found.");
                }
            } else {
                commandHistory.add(input);  // Store the command in history
            }
        }
        scanner.close();
    }

    private static String reverseSearch(List<String> history, String query) {
        for (int i = history.size() - 1; i >= 0; i--) {
            if (history.get(i).contains(query)) {
                return history.get(i);  // Return the most recent match
            }
        }
        return null;
    }
}
