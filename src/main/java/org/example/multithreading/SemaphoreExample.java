package org.example.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    // Create a Semaphore with 2 permits (resources)
    private static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        // Start 5 threads
        for (int i = 1; i <= 5; i++) {
            new Thread(new Worker(i)).start();
        }
    }

    static class Worker implements Runnable {
        private final int id;

        Worker(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread " + id + " is trying to acquire a permit.");
                
                // Acquire a permit from the semaphore
                semaphore.acquire();
                System.out.println("Thread " + id + " has acquired a permit.");

                // Simulate some work by sleeping
                Thread.sleep(2000);  // Simulate work for 2 seconds

                // Release the permit after work is done
                System.out.println("Thread " + id + " is releasing a permit.");
                semaphore.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
