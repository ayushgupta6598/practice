package org.example.Stream;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamBeginner {
    //    Beginner Level
//1. Convert Stream to List: Given a list of integers, use Collectors.toList() to store all numbers greater than 10 in a new list.
    public static void main(String[] args) {
/**
        Which One to Use when using merge fucntion in collectors.toMap()?
        Find the max/min? → Integer::max or Integer::min
        Sum values? → (x, y) -> x + y
        Keep latest? → (x, y) -> y
        Keep first? → (x, y) -> x
        Store all? → Use Collectors.groupingBy() instead of toMap()
        Concatenate values? → (x, y) -> x + ", " + y*/


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<String> names = Arrays.asList("John", "Mary", "Jane", "Rahul", "Puneet");
//        list.stream().limit(5).fo\
        list.stream().filter(x -> x > 3).collect(Collectors.toList()).forEach(System.out::println);

//    2. Find Unique Words:Given a list of words, use Collectors.toSet() to collect only the unique words.
        List<String> words = Arrays.asList("hello", "world", "hello", "world", "Random", "Word");
        System.out.println("_________________________________________");
        System.out.println(words.stream().collect(Collectors.toSet()));
        System.out.println("_________________________________________");

//    Word Frequency Counter: Write a function that takes a list of words and returns a map with
//    words as keys and their occurrences as values

        System.out.println("_________________________________________");


        System.out.println(words.stream().map(String::toLowerCase).collect(Collectors.toMap(x -> x, y -> 1, (x, y) -> x + y)));
        System.out.println(words.stream().map(String::toLowerCase).collect(Collectors.groupingBy(x -> x, Collectors.counting())));
        System.out.println("_________________________________________");


//    4. String Joining: Given a list of names, use Collectors.joining() to concatenate them with a , separator.
        System.out.println("_________________________________________");
        String collect = names.stream().collect(Collectors.joining(", "));
        System.out.println(collect);
        System.out.println("_________________________________________");

//    5. Partition Numbers into Even and Odd: Given a list of numbers, use Collectors.partitioningBy() to separate even and odd numbers.
        Map<Boolean, List<Integer>> collect1 = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(collect1);


//        6. Group Employees by Department: Given a list of Employee(name, department),
//        use Collectors.groupingBy() to return a map of department names and lists of employee names.

        List<Employee> employees = List.of(
                new Employee("Alice", "HR", 1000, "L1"),
                new Employee("Bob", "Engineering",50000,"L2"),
                new Employee("Charlie", "Engineering",10000, "L1"),
                new Employee("David", "Marketing",89000, "L3"),
                new Employee("Eve", "HR",80000, "L5")
        );
        Map<String, List<Employee>> collect2 = employees.stream().collect(Collectors.groupingBy
                (Employee::getDepartment, Collectors.toList()));
        System.out.println("Solution 6) "+ collect2);
        System.out.println("_________________________________________");


        Map<String, List<String>> groupedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::toString, Collectors.toList())
                ));
        System.out.println(groupedByDepartment);

//        7. Find the Longest Word:Given a list of strings,
        System.out.println("_________________________________________");

        Optional<String> max = words.stream().max(Comparator.comparingInt((String::length)));
        System.out.println(max.get());

        Optional<String> collect3 = words.stream().collect(Collectors.reducing((a1, a2) -> a1.length() > a2.length() ? a1 : a2));
        System.out.println(collect3.get());

        System.out.println("_________________________________________");
//        8. Sum of Salaries by Department:Given a list of Employee(name, department, salary)
//        , use Collectors.groupingBy() and Collectors.summingDouble() to calculate total salaries per department.

        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingInt(Employee::getSalary))));


//        9. Sort and Collect into a Map:Given a list of students (name, score),
//        collect them into a Map<String, Integer> where the highest scoring student is stored for each name.
//        Use Collectors.toMap() with a merge function.


        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 92));
        students.add(new Student("Charlie", 78));
        students.add(new Student("David", 90));
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 92));
        students.add(new Student("Charlie", 78));
        students.add(new Student("David", 90));
        students.add(new Student("Alice", 90)); // Duplicate name with higher score
        students.add(new Student("Bob", 89)); //

            // Sorting students by score in descending order
//            students.stream().collect(Collectors.toMap(Student::getName,Student::getScore,(x,y)->x+y));
        System.out.println("9) "+students.stream().collect(Collectors.toMap(Student::getName,Student::getScore,Integer::max)));

        System.out.println(  students.stream()
                .collect(Collectors.groupingBy(
                        Student::getName,
                        Collectors.mapping(Student::getScore, Collectors.toList()) // Store as List
                )));

//        10. Collect Employees’ Names by Department Using Collectors.mapping(): Modify
//            the solution of question 6 to collect only employee names instead of full objects.
        System.out.println("_________________________________________");
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName,Collectors.toList()))));

//        Advanced Level
//        11. Multi-Level Grouping: Given a list of Employee(name, department, role), group them first by department, then by role.
        System.out.println("_________________________________________");
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getRole, Collectors.toList()))));

//**        can modify it to collect only names if needed. *//
        System.out.println("_________________can modify it to collect only names if needed________________________");
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getRole,Collectors.mapping(Employee::getName, Collectors.toList())))));


//        12. Create a Custom Collector: Implement a custom collector that collects a stream of
//        integers into a comma-separated string without using Collectors.joining().
        System.out.println("_________________Comma-separated string without using Collectors.joining().________________________");
        List<Integer> numbers= List.of(1,2,3,4,5,6,7,8,9,0,10);
        System.out.println(numbers.stream().toList());

        int maxGenerateCounter = 6;
        System.out.println( "Using Splitter: ");
        StreamSupport.stream(Spliterators.spliteratorUnknownSize(new Iterator<String>() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                // simplistic solution, see below for explanation
                return counter < maxGenerateCounter;
            }
            @Override
            public String next() {
                // executing stuff
                // providing info for 'stopping' the stream
                counter++; // for simplicity
                if( counter > maxGenerateCounter) {
                    return null; // this could be any answer. It will be filtered out.
                }
                return "String-" + counter;
            }
        }, Spliterator.IMMUTABLE), false).forEach( System.out::println);

//        13. Concurrent Map Collection:Modify the solution of question 9 to use Collectors.toConcurrentMap().

        System.out.println(students.stream().collect(Collectors.toConcurrentMap(Student::getName, Student::getScore,Integer::max)));


        students.stream().sorted((x1,x2 )-> Integer.compare(x2.getScore(),x1.getScore())).collect(
                Collectors.toConcurrentMap(Student::getName,Student::getScore, Integer::max, ConcurrentHashMap::new));

        System.out.println(String.valueOf(students.stream().sorted((x1, x2 )-> Integer.compare(x2.getScore(),x1.getScore())).collect(
                Collectors.toConcurrentMap(Student::getName,Student::getScore, Integer::max))));

//        14. Find Top N Salaries Per Department: Given a list of employees with salary, return a map of department names to a list of top 3 highest-paid employees.

        Map<String, List<String>> topSalariesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list1 -> list1.stream()
                                        .sorted(Comparator.comparing(Employee::getSalary).reversed()) // Sort by salary (descending)
                                        .limit(3) // Take top 3 per department
                                        .map(Employee::getName) // Extract names only
                                        .collect(Collectors.toList()) // Collect names into a list
                        )
                ));

        // Print results
        System.out.println(topSalariesByDept);

//        System.out.println( employees.stream().sorted(Comparator.comparing(Employee::getSalary, Comparator.naturalOrder())).
//                limit(3).collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName, Collectors.toList()))));

//
//
//        15. Find Average Salary Using summarizingDouble(): Compute the average salary of employees in a company using Collectors.summarizingDouble().

        System.out.println(employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getAverage());
    }

}

 class CustomCollectorExample {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10);

        // Using the custom collector to get a comma-separated string
        String result = numbers.stream().collect(new CommaSeparatedCollector());

        System.out.println("_________________Comma-separated string without using Collectors.joining().________________________");
        System.out.println(result);
    }

    // Custom collector to collect integers into a comma-separated string
    public static class CommaSeparatedCollector implements Collector<Integer, StringBuilder, String> {

        @Override
        public Supplier<StringBuilder> supplier() {
            return StringBuilder::new;
        }

        @Override
        public BiConsumer<StringBuilder, Integer> accumulator() {
            return (sb, num) -> {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(num);
            };
        }

        @Override
        public BinaryOperator<StringBuilder> combiner() {
            return (sb1, sb2) -> sb1.append(sb2);
        }

        @Override
        public Function<StringBuilder, String> finisher() {
            return StringBuilder::toString;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.emptySet();
        }
    }
}
class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + " - " + score;
    }
}



class Employee {
    private String name;
    private String department;
    private Integer salary;
    private String role;

    // Constructor
    public Employee(String name, String department, Integer salary, String role) {
        this.name = name;
        this.department = department;
        this.salary= salary;
        this.role= role;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
    public Integer getSalary() {
        return salary;
    }
    public String getRole(){
        return role;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return "Name: "+name+ " Department: "+department +" Salary: "+salary+" Role: "+role;
    }

    // Equals and hashCode (optional, but good practice for collection-based operations)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department);
    }
}

