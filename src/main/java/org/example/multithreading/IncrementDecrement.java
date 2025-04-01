package org.example.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class IncrementDecrement {

    // Shared value
    private static int value = 0;
    
    // ReentrantLock and Condition objects
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition canIncrement = lock.newCondition();
    private static final Condition canDecrement = lock.newCondition();

    // Incrementer thread
    static class Incrementer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    try {
                        // Wait if the value is 5 (cannot increment)
                        while (value == 5) {
                            System.out.println("Incrementer waiting, value is 5.");
                            canIncrement.await();  // Wait until it's less than 5
                        }
                        
                        // Increment the value
                        value++;
                        System.out.println("Incremented: " + value);
                        
                        // Notify the decrementer that it can now decrement
                        canDecrement.signal();
                    } finally {
                        lock.unlock();
                    }
                    Thread.sleep(500);  // Simulate time taken to increment
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // Decrementer thread
    static class Decrementer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    try {
                        // Wait if the value is 0 (cannot decrement)
                        while (value == 0) {
                            System.out.println("Decrementer waiting, value is 0.");
                            canDecrement.await();  // Wait until it's greater than 0
                        }
                        
                        // Decrement the value
                        value--;
                        System.out.println("Decremented: " + value);
                        
                        // Notify the incrementer that it can now increment
                        canIncrement.signal();
                    } finally {
                        lock.unlock();
                    }
                    Thread.sleep(500);  // Simulate time taken to decrement
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create and start the incrementer and decrementer threads
        Thread incrementer = new Thread(new Incrementer());
        Thread decrementer = new Thread(new Decrementer());
        
        incrementer.start();
        decrementer.start();
    }
}
