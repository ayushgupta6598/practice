package org.example.multithreading;

public class LivelockExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lock1) {
                    System.out.println("Thread 1: Holding lock 1...");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    System.out.println("Thread 1: Trying to acquire lock 2...");
                    synchronized (lock2) {
                        System.out.println("Thread 1: Acquired lock 2!");
                        break;
                    }
                }
                // Thread 1 releases lock1 and retries
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lock2) {
                    System.out.println("Thread 2: Holding lock 2...");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    System.out.println("Thread 2: Trying to acquire lock 1...");
                    synchronized (lock1) {
                        System.out.println("Thread 2: Acquired lock 1!");
                        break;
                    }
                }
                // Thread 2 releases lock2 and retries
            }
        });

        thread1.start();
        thread2.start();
    }
}
