package com.hyb.ds.队列;

public class CircleQueueTest {
    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(5);
        circleQueue.insertQueue(1);
        circleQueue.insertQueue(4);
        circleQueue.insertQueue(5);
        circleQueue.insertQueue(7);
        circleQueue.insertQueue(0);
        System.out.println(circleQueue.isFull());
        System.out.println(circleQueue.isEmpty());
        System.out.println(circleQueue.popQueue());
    }
}
