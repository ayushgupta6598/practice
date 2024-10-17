package org.example.java8;

public class AbstractVsInterface {
    abstract class Animal {
        String name;

        // Abstract method (no body)
        abstract void sound();

        // Concrete method (with implementation)
        void sleep() {
            System.out.println(name + " is sleeping");
        }
    }

    class Dog extends Animal {
        Dog(String name) {
            this.name = name;
        }

        // Implementing the abstract method
        @Override
        void sound() {
            System.out.println(name + " barks");
        }
    }


//Interface

    interface Vehicle {
        // Abstract method
        void start();

        // Default method (Java 8+)
        default void stop() {
            System.out.println("Vehicle has stopped");
        }
    }

    class Car implements Vehicle {
        @Override
        public void start() {
            System.out.println("Car starts");
        }

        // The default stop() method is inherited but can be overridden if needed
    }

}
