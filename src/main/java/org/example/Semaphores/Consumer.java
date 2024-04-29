package org.example.Semaphores;

import java.util.Queue;
import java.util.concurrent.locks.Lock;

class Consumer implements Runnable {
    private final Buffer buffer;
    private final int id;

    public Consumer(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    public void run() {
        while (true) {
            try {
                int item = buffer.consume();
                consumeItem(item);
                Thread.sleep(1000); // Simulate consumption time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consumeItem(int item) {
        System.out.println("Consumer " + id + " consumed: " + item);
    }
}