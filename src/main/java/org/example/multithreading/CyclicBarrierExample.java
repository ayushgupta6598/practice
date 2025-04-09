package org.example.multithreading;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, () -> System.out.println("All threads are ready."));

        // Thread 1
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 arrived.");
            try {
                barrier.await();  // Wait for all threads
            } catch (Exception e) {}
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 arrived.");
            try {
                barrier.await();  // Wait for all threads
            } catch (Exception e) {}
        });

        // Thread 3
        Thread t3 = new Thread(() -> {
            System.out.println("Thread 3 arrived.");
            try {
                barrier.await();  // Wait for all threads
            } catch (Exception e) {}
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
