package org.example.waitandnotify;

import java.util.LinkedList;
import java.util.Queue;

public class Client {
    public  static  void main(String[] args) {
         Queue<Integer> buffer = new LinkedList<>();
         int capacity = 5;
         Producer p1= new Producer(buffer,capacity);
         Consumer c1= new Consumer(buffer,capacity);
         Consumer c2= new Consumer(buffer,capacity);
         Thread t1= new Thread(p1,"producer");
         Thread t2= new Thread(c1,"consumer1");
         Thread t3= new Thread(c2,"consumer2");
         t1.start();
         t2.start();
         t3.start();
    }

}
