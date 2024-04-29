package org.example.waitandnotify;

import java.util.Queue;

public class Producer implements Runnable {
    private Queue<Integer> buffer;
    private int size;

    public Producer(Queue<Integer> buffer, int size) {
        this.buffer = buffer;
        this.size = size;
    }

    public  void run(){
        while(true) {
            synchronized (buffer) {
                while (buffer.size() == size) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                int rand = (int) (Math.random() * 100);
                buffer.add(rand);
                System.out.println("produced: " + rand + "size: " + buffer.size());
                buffer.notifyAll();
            }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);

            }
        }

    }

}
