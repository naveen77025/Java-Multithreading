package org.example.Semaphores;

import java.util.concurrent.Semaphore;

class Buffer {
    private final int[] buffer;
    private final int bufferSize;
    private int in;
    private int out;
    private Semaphore mutex;
    private Semaphore emptySlots;
    private Semaphore filledSlots;

    public Buffer(int size) {
        bufferSize = size;
        buffer = new int[bufferSize];
        in = 0;
        out = 0;
        mutex = new Semaphore(1);
        emptySlots = new Semaphore(bufferSize);
        filledSlots = new Semaphore(0);
    }

    public void produce(int item) throws InterruptedException {
        emptySlots.acquire();
        mutex.acquire();
        buffer[in] = item;
        in = (in + 1) % bufferSize;
        mutex.release();
        filledSlots.release();
    }

    public int consume() throws InterruptedException {
        filledSlots.acquire();
        mutex.acquire();
        int item = buffer[out];
        out = (out + 1) % bufferSize;
        mutex.release();
        emptySlots.release();
        return item;
    }
}
