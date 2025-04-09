package org.example.multithreading;

import java.util.concurrent.*;

public class ExchangerExample {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        
        // Thread 1: Sends a string to Thread 2
        Thread thread1 = new Thread(() -> {
            try {
                String message = "Message from Thread 1";
                System.out.println("Thread 1 sending: " + message);
                // Exchange data with thread2
                String response = exchanger.exchange(message);
                System.out.println("Thread 1 received: " + response);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Thread 2: Sends a string to Thread 1
        Thread thread2 = new Thread(() -> {
            try {
                String message = "Message from Thread 2";
                System.out.println("Thread 2 sending: " + message);
                // Exchange data with thread1
                String response = exchanger.exchange(message);
                System.out.println("Thread 2 received: " + response);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
