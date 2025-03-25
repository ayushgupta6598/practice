package org.example;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    String name;
    int age;
    
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class MappingExample {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 25)
        );

        Map<Integer, List<String>> ageToNames = people.stream()
            .collect(Collectors.groupingBy(
                person -> person.age,
                    Collectors.mapping(person -> person.name, Collectors.toList()) // Extracting only names
            ));

        System.out.println(ageToNames); // Output: {25=[Alice, Charlie], 30=[Bob]}
    }
}
