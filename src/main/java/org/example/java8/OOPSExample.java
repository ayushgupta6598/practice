package org.example.java8;

// Encapsulation: Hiding data using private fields and public getters/setters
class Animal {
    private String name;

    public Animal(String name) { // Constructor
        this.name = name;
    }

    public String getName() { // Getter method
        return name;
    }
}

// Inheritance: Dog inherits properties of Animal
class Dog extends Animal {
    public Dog(String name) {
        super(name); // Calling parent constructor
    }

    // Polymorphism: Overriding method
    @Override
    public String getName() {
        return "Dog's name is: " + super.getName();
    }
}

// Abstraction: Using an abstract class
abstract class Vehicle {
    abstract void start(); // Abstract method
}

class Car extends Vehicle {
    @Override
    void start() { // Implementing abstract method
        System.out.println("Car is starting...");
    }
}

public class OOPSExample {
    public static void main(String[] args) {
        Animal a = new Dog("Buddy"); // Polymorphism: Parent reference, child object
        System.out.println(a.getName());

        Vehicle v = new Car(); // Abstraction: Using abstract class reference
        v.start();
    }
}
