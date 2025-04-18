package org.example.java8;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapKeyBehavior {

    public static void main(String[] args) {

        // 1. Mutable Key Example
        System.out.println("1️⃣ Mutable Key:");
        A mutableKey = new A(1, "Hi");
        Map<A, String> mutableMap = new HashMap<>();
        mutableMap.put(mutableKey, "Hello");
        mutableKey.setStr("Changed"); // Mutating the key after insertion
        System.out.println("Get with mutated key: " + mutableMap.get(mutableKey)); // Likely null
        System.out.println();

        // 2. equals() without hashCode() / hashCode() without equals()
        System.out.println("2️⃣ equals() and hashCode():");
        A obj1 = new A(1, "Test");
        A obj2 = new A(1, "Test");

        System.out.println("obj1.equals(obj2): " + obj1.equals(obj2));
        System.out.println("obj1.hashCode() == obj2.hashCode(): " + (obj1.hashCode() == obj2.hashCode()));
        System.out.println();

        // 3. HashMap logic – Different objects with same content
        System.out.println("3️⃣ Two objects with same values:");
        Map<A, String> map = new HashMap<>();
        map.put(new A(1, "Hi"), "First");
        map.put(new A(1, "Hi"), "Second");
        System.out.println("Map size (no override): " + map.size()); // 2 if equals/hashCode not overridden
        System.out.println();

        // 4. Custom class with overridden equals/hashCode
        System.out.println("4️⃣ CustomKey with proper equals/hashCode:");
        Map<CustomKey, String> customMap = new HashMap<>();
        customMap.put(new CustomKey("Ayush", "Gupta", LocalDate.of(1999, 1, 1)), "Dev");
        customMap.put(new CustomKey("Ayush", "Gupta", LocalDate.of(1999, 1, 1)), "Backend Engineer");

        System.out.println("Map size (CustomKey): " + customMap.size()); // should be 1
        System.out.println("Value: " + customMap.get(new CustomKey("Ayush", "Gupta", LocalDate.of(1999, 1, 1))));
    }

    // Custom key without equals/hashCode overridden
    static class A {
        private int id;
        private String str;

        public A(int id, String str) {
            this.id = id;
            this.str = str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        // Uncomment these to see difference in behavior
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            A a = (A) o;
//            return id == a.id && Objects.equals(str, a.str);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(id, str);
//        }
    }

    // Custom key with proper equals/hashCode
    static class CustomKey {
        private String firstName;
        private String lastName;
        private LocalDate birthDate;

        public CustomKey(String firstName, String lastName, LocalDate birthDate) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CustomKey)) return false;
            CustomKey that = (CustomKey) o;
            return Objects.equals(firstName, that.firstName) &&
                   Objects.equals(lastName, that.lastName) &&
                   Objects.equals(birthDate, that.birthDate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, birthDate);
        }
    }
}
