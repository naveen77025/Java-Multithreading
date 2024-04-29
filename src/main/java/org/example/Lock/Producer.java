package org.example.Lock;

import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {
    private Queue<Integer> buffer;
    private int size;
    private Lock lock;

    public Producer(Queue<Integer> buffer, int size,Lock lock) {
        this.buffer = buffer;
        this.size = size;
        this.lock=lock;
    }

    public  void run(){
        while(true) {
            lock.lock();
                while (buffer.size() != size) {
                    int rand = (int) (Math.random() * 100);
                    buffer.add(rand);
                    System.out.println("produced: " + rand + "size: " + buffer.size());
                }
                lock.unlock();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
            }
        }

    }

}
