package org.example.multithreading;

import java.util.concurrent.*;

public class ExecutorExamples {
    /**Explanation:
     FixedThreadPool:

     Creates a pool with a fixed number of threads. In this case, we have set it to 2 threads.

     Tasks are submitted and executed by reusing these 2 threads.

     CachedThreadPool:

     Creates a thread pool that can dynamically add threads as needed but will reuse previously constructed threads.

     Good for short-lived tasks where the number of threads can vary.

     SingleThreadExecutor:

     Ensures that all submitted tasks are executed sequentially by a single worker thread.

     It’s useful when the tasks need to be executed in order and there should be no concurrency.

     ScheduledThreadPool:

     Executes tasks periodically.

     schedule() runs a task once after a fixed delay,

     scheduleAtFixedRate() runs tasks periodically with a fixed time interval,

     scheduleWithFixedDelay() runs tasks with a fixed delay between the end of one execution and the start of the next.*/


    public static void main(String[] args) {
        
        // 1. FixedThreadPool
        System.out.println("FixedThreadPool Example:");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 4; i++) {
            fixedThreadPool.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " is executing FixedThreadPool task.");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        fixedThreadPool.shutdown();

        // 2. CachedThreadPool
        System.out.println("\nCachedThreadPool Example:");
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++) {
            cachedThreadPool.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " is executing CachedThreadPool task.");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        cachedThreadPool.shutdown();

        // 3. SingleThreadExecutor
        System.out.println("\nSingleThreadExecutor Example:");
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 4; i++) {
            singleThreadExecutor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " is executing SingleThreadExecutor task.");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        singleThreadExecutor.shutdown();

        // 4. ScheduledThreadPool
        System.out.println("\nScheduledThreadPool Example:");
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is executing ScheduledThreadPool task.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        // Schedule the task to run after a 2-second delay
        scheduledThreadPool.schedule(task, 2, TimeUnit.SECONDS);
        // Schedule the task to run periodically with a 2-second initial delay and 3-second interval
        scheduledThreadPool.scheduleAtFixedRate(task, 2, 3, TimeUnit.SECONDS);
        // Schedule the task to run with a fixed delay between executions
        scheduledThreadPool.scheduleWithFixedDelay(task, 2, 3, TimeUnit.SECONDS);
        
        // Shutdown after some time to allow tasks to execute
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledThreadPool.shutdown();
    }

  }
