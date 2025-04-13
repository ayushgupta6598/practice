package org.example.multithreading;

public class OddEvenPrinter {
    private static int num = 1;
    private static final int MAX = 10;

    public static void main(String[] args) {
        Object lock = new Object();

        Runnable printOdd = () -> {
            while (num <= MAX) {
                synchronized (lock) {
                    if (num % 2 == 1) {
                        System.out.println("Odd: " + num++);
                        lock.notifyAll();
                    } else {
                        try { lock.wait(); } catch (InterruptedException e) {}
                    }
                }
            }
        };

        Runnable printEven = () -> {
            while (num <= MAX) {
                synchronized (lock) {
                    if (num % 2 == 0) {
                        System.out.println("Even: " + num++);
                        lock.notifyAll();
                    } else {
                        try { lock.wait(); } catch (InterruptedException e) {}
                    }
                }
            }
        };

        new Thread(printOdd).start();
        new Thread(printEven).start();
    }
}
