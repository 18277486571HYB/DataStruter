package com.hyb.ds.队列;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        for (int i = 0; i < 10; i++) {
            arrayQueue.insert(i);
        }
        for (int i = 0; i < 10; i++) {
            Object remove = arrayQueue.remove();
            System.out.println(remove);
        }
    }
}
