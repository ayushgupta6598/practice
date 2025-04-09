package org.example.multithreading;

import java.util.concurrent.*;

class DelayedItem implements Delayed {
    private final long delayTime;
    private final long startTime;

    public DelayedItem(long delayTime) {
        this.delayTime = delayTime;
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert((startTime + delayTime - System.currentTimeMillis()), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.startTime < ((DelayedItem) o).startTime) return -1;
        if (this.startTime > ((DelayedItem) o).startTime) return 1;
        return 0;
    }

    public String toString() {
        return "DelayedItem with delay: " + delayTime;
    }
}

public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedItem> queue = new DelayQueue<>();

        queue.put(new DelayedItem(5000));  // 5-second delay
        queue.put(new DelayedItem(3000));  // 3-second delay

        System.out.println("Consuming after delay:");
        while (true) {
            DelayedItem item = queue.take();  // Blocks until delay time is over
            System.out.println("Consumed: " + item);
        }
    }
}
