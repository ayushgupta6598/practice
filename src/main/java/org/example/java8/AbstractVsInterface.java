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
        @Override
        public void stop(){
            System.out.println("Car stops");

        }


        // Abstract class for common payment behavior
        abstract class Payment {
            double amount;
            String currency;

            Payment(double amount, String currency) {
                this.amount = amount;
                this.currency = currency;
            }

            // Common method: All payments incur a processing fee
            double applyProcessingFee() {
                double fee = 0.02 * amount;  // 2% fee
                System.out.println("Processing fee of " + fee + " applied.");
                return fee;
            }

            // Abstract method: Specific payment types will implement this
            abstract void makePayment();
        }

        // Subclass for credit card payment
        class CreditCardPayment extends Payment {
            String cardNumber;

            CreditCardPayment(double amount, String currency, String cardNumber) {
                super(amount, currency);
                this.cardNumber = cardNumber;
            }

            @Override
            void makePayment() {
                System.out.println("Processing Credit Card payment of " + amount + " " + currency);
                // Logic for credit card payment
            }
        }

        // Subclass for PayPal payment
        class PayPalPayment extends Payment {
            String email;

            PayPalPayment(double amount, String currency, String email) {
                super(amount, currency);
                this.email = email;
            }

            @Override
            void makePayment() {
                System.out.println("Processing PayPal payment of " + amount + " " + currency);
                // Logic for PayPal payment
            }
        }




        // Interface for payment validation
        interface PaymentValidator {

            boolean validateDetails();  // Abstract method to validate payment details
        }


        // Interface for refunds
        interface Refundable {
            void refund(double amount);  // Abstract method to refund payment
        }

        // Implementing validation and refund for credit card payment
        class creditCardPayment implements PaymentValidator, Refundable {
            private String cardNumber;
            private double amount;

            public creditCardPayment(String cardNumber, double amount) {
                this.cardNumber = cardNumber;
                this.amount = amount;
            }

            // Implementing validation
            @Override
            public boolean validateDetails() {
                System.out.println("Validating Credit Card number: " + cardNumber);
                // Example: Check if card number is valid (dummy validation)
                return cardNumber.length() == 16;
            }

            // Implementing refund
            @Override
            public void refund(double amount) {
                System.out.println("Refunding " + amount + " to Credit Card " + cardNumber);
                // Logic for processing refund
            }
        }

        // Implementing validation and refund for PayPal payment
        class PayPalPayment1 implements PaymentValidator, Refundable {
            private String email;
            private double amount;

            public PayPalPayment1(String email, double amount) {
                this.email = email;
                this.amount = amount;
            }

            // Implementing validation
            @Override
            public boolean validateDetails() {
                System.out.println("Validating PayPal account: " + email);
                // Example: Check if PayPal email is valid (dummy validation)
                return email.contains("@");
            }

            // Implementing refund
            @Override
            public void refund(double amount) {
                System.out.println("Refunding " + amount + " to PayPal account " + email);
                // Logic for processing refund
            }
        }


        // The default stop() method is inherited but can be overridden if needed
    }

}
