package org.example.Lock;

import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable{
    private final Queue<Integer> buffer;
    private int size;
    private Lock lock;

    public Consumer(Queue<Integer> buffer, int size, Lock lock) {
        this.buffer = buffer;
        this.size = size;
        this.lock=lock;
    }

    public  void run(){
        while(true) {
                lock.lock();
                while (!buffer.isEmpty()) {
                    int val = buffer.poll();
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " consumed: " + val + " size: " + buffer.size());
                }
                lock.unlock();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

        }
    }
}
