package org.example.Semaphores;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
     public static void main(String[] args) {
          Buffer buffer = new Buffer(6);

          Producer[] producers = new Producer[6];
          Consumer[] consumers = new Consumer[5];

          // Create producer threads
          for (int i = 0; i < producers.length; i++) {
               producers[i] = new Producer(buffer, i + 1);
               Thread producerThread= new Thread(producers[i]);
               producerThread.start();
          }

          // Create consumer threads
          for (int i = 0; i < consumers.length; i++) {
               consumers[i] = new Consumer(buffer, i + 1);
               Thread consumerThread= new Thread(consumers[i]);
               consumerThread.start();
          }
     }
}