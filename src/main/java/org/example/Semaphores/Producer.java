package org.example.Semaphores;

import java.util.Queue;
import java.util.concurrent.locks.Lock;

class Producer implements Runnable {
    private final Buffer buffer;
    private final int id;

    public Producer(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    public void run() {
        while (true) {
            try {
                buffer.produce(id);
                System.out.println("Produced item : "+id);
                Thread.sleep(500); // Simulate production time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
