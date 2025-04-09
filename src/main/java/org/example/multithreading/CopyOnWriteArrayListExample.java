package org.example.multithreading;

import java.util.concurrent.*;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        
        // Add some elements to the list
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Create a thread that modifies the list
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate some delay
                list.add("Date");
                System.out.println("Writer thread added: Date");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Create a thread that reads from the list
        Thread readerThread = new Thread(() -> {
            for (String fruit : list) {
                System.out.println("Reader thread read: " + fruit);
            }
        });

        // Start the reader thread and writer thread
        readerThread.start();
        writerThread.start();

        try {
            readerThread.join();
            writerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Final list output
        System.out.println("Final list: " + list);
    }
}
