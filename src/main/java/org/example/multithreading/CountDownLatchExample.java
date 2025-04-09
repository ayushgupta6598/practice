package org.example.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);  // Wait for 3 events
        
        // Thread 1
        Thread t1 = new Thread(() -> {
            System.out.println("Task 1 is done.");
            latch.countDown();
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            System.out.println("Task 2 is done.");
            latch.countDown();
        });

        // Thread 3
        Thread t3 = new Thread(() -> {
            System.out.println("Task 3 is done.");
            latch.countDown();
        });

        t1.start();
        t2.start();
        t3.start();

        // Main thread waits for all tasks to finish
        latch.await();  // Waits until count reaches 0
        System.out.println("All tasks are done.");
    }
}
