package org.example.Lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public  static  void main(String[] args) {
         Queue<Integer> buffer = new LinkedList<>();
         int capacity = 5;
         Lock lock= new ReentrantLock();
         Producer p1= new Producer(buffer,capacity,lock);
         Consumer c1= new Consumer(buffer,capacity,lock);
         Consumer c2= new Consumer(buffer,capacity,lock);
         Thread t1= new Thread(p1,"producer");
         Thread t2= new Thread(c1,"consumer1");
         Thread t3= new Thread(c2,"consumer2");
         t1.start();
         t2.start();
         t3.start();
    }

}
