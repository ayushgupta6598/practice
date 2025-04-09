package org.example.multithreading;

import java.util.concurrent.*;
import java.util.*;

class Task implements Comparable<Task> {
    private final int priority;
    private final String taskName;

    public Task(int priority, String taskName) {
        this.priority = priority;
        this.taskName = taskName;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task other) {
        // Higher priority tasks should come first
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Task{name='" + taskName + "', priority=" + priority + "}";
    }
}

public class PriorityBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        // Create a PriorityBlockingQueue
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        // Add tasks to the queue with different priorities
        queue.put(new Task(3, "Task 3")); // Lower priority (higher number)
        queue.put(new Task(1, "Task 1")); // Higher priority (lower number)
        queue.put(new Task(2, "Task 2")); // Medium priority

        // Consume tasks based on priority
        System.out.println("Processing tasks in priority order:");
        for (int i = 0; i < 3; i++) {
            Task task = queue.take();  // Take the task with the highest priority
            System.out.println(task);
        }
    }
}
