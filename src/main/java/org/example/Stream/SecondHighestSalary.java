package org.example.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class SecondHighestSalary {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Ayush", 4000);
        map.put("Rahul", 5000);
        map.put("Mahes", 5000);
        map.put("Jitesh", 9000);

        Optional<Map.Entry<String, Integer>> first = map.entrySet().stream()
                .sorted(Comparator.comparing(k -> k.getValue(), Comparator.reverseOrder()))
                .skip(1).findFirst();


        List<Integer> distinctSalaries = map.values()
                .stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Optional<Integer> secondHighestSalary = map.values().stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        map.entrySet().stream()
                .filter(entry -> {
                    // Inner stream to calculate second highest salary
                    Integer secondHighest = map.values().stream()
                            .distinct()
                            .sorted(Comparator.reverseOrder())
                            .skip(1)
                            .findFirst()
                            .orElse(null);
                    return Objects.equals(entry.getValue(), secondHighest);
                })
                .forEach(entry ->
                        System.out.println(entry.getKey() + " earns the second highest salary: " + entry.getValue()));
    }
}
