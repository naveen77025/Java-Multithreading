package org.example.waitandnotify;

import java.util.Queue;

public class Consumer implements Runnable{
    private final Queue<Integer> buffer;
    private int size;

    public Consumer(Queue<Integer> buffer, int size) {
        this.buffer = buffer;
        this.size = size;
    }

    public  void run(){
        while(true) {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int val = buffer.poll();
                String threadName=Thread.currentThread().getName();
                System.out.println(threadName+" consumed: " + val + " size: " + buffer.size());
                buffer.notifyAll();
            }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

        }
    }
}
