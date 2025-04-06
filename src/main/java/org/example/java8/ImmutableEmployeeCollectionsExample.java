package org.example.java8;

import java.util.*;

/**
 * IMMUTABLE EMPLOYEE CLASS – KEY POINTS
 * -------------------------------------
 *
 * ✅ Goal: Create an immutable Employee class with the following fields:
 *    - int id
 *    - String name
 *    - Date dateOfJoining (mutable)
 *    - Map<String, String> details (mutable)
 *
 * ✅ Key principles:
 *    - Use final class and fields
 *    - No setters
 *    - Defensive copies of mutable fields
 *    - Return unmodifiable structures in getters
 *
 * ✅ Difference between java.util.Date and java.time.LocalDate:
 *    | Feature         | java.util.Date    | java.time.LocalDate |
 *    |-----------------|-------------------|----------------------|
 *    | Includes time?  | ✅ Yes            | ❌ No               |
 *    | Mutable?        | ✅ Yes            | ❌ No               |
 *    | Thread-safe?    | ❌ No             | ✅ Yes              |
 */

/**
 * Demonstrates immutability with List, Set, Map, and Array.
 * Ensures defensive copies and unmodifiable views for all collections.
 */
public final class ImmutableEmployeeCollectionsExample {
    private final String name;
    private final List<String> skills;
    private final Set<String> certifications;
    private final Map<String, String> details;
    private final int[] ratings;

    public ImmutableEmployeeCollectionsExample(
            String name,
            List<String> skills,
            Set<String> certifications,
            Map<String, String> details,
            int[] ratings) {

        this.name = name;

        // Defensive copy and make unmodifiable
        this.skills = Collections.unmodifiableList(new ArrayList<>(skills));
        this.certifications = Collections.unmodifiableSet(new HashSet<>(certifications));
        this.details = Collections.unmodifiableMap(new HashMap<>(details));
        this.ratings = Arrays.copyOf(ratings, ratings.length); // Defensive copy for array
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills; // Already unmodifiable
    }

    public Set<String> getCertifications() {
        return certifications; // Already unmodifiable
    }

    public Map<String, String> getDetails() {
        return details; // Already unmodifiable
    }

    public int[] getRatings() {
        return Arrays.copyOf(ratings, ratings.length); // Return defensive copy
    }

    public static void main(String[] args) {
        List<String> skills = new ArrayList<>(List.of("Java", "Spring Boot"));
        Set<String> certs = new HashSet<>(Set.of("AWS", "Docker"));
        Map<String, String> info = new HashMap<>();
        info.put("Role", "Developer");
        info.put("Team", "Platform");

        int[] ratings = {5, 4, 3};

        ImmutableEmployeeCollectionsExample emp = new ImmutableEmployeeCollectionsExample(
                "Ayush Gupta",
                skills,
                certs,
                info,
                ratings
        );

        System.out.println("Name: " + emp.getName());
        System.out.println("Skills: " + emp.getSkills());
        System.out.println("Certifications: " + emp.getCertifications());
        System.out.println("Details: " + emp.getDetails());
        System.out.println("Ratings: " + Arrays.toString(emp.getRatings()));

        // Try modifying the original lists
        skills.add("Kubernetes");
        certs.add("GCP");
        info.put("Location", "Berlin");
        ratings[0] = 1;

        System.out.println("\nAfter modifying original inputs:");
        System.out.println("Skills: " + emp.getSkills());
        System.out.println("Certifications: " + emp.getCertifications());
        System.out.println("Details: " + emp.getDetails());
        System.out.println("Ratings: " + Arrays.toString(emp.getRatings()));

        // Try modifying the returned collections (should throw exception)
        try {
            emp.getSkills().add("Terraform");
        } catch (UnsupportedOperationException e) {
            System.out.println("Modification of skills failed: " + e.getMessage());
        }
    }
}


