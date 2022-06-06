package com.hyb.ds.队列;

public class ArrayQueue {

    private final int maxSize;    // 队列最大长度
    private final Object[] queArray;    // 队列数组
    private int front;    // 队列头
    private int rear;    // 队列尾
    private int nItems;    // 队列中元素个数

    public ArrayQueue(int s) {
        maxSize = s;
        queArray = new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(Object j) {
        if (rear == maxSize - 1)
            rear = -1;
        queArray[++rear] = j;
        nItems++;
    }

    public Object remove() {
        Object temp = queArray[front++];
        if (front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }

    public Object peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }

    public void clear() {
        for (int i = 0; i < maxSize; i++)
            queArray[i] = null;
        nItems = 0;
        front = 0;
        rear = -1;
    }

    public Object[] toArray() {
        return queArray;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < maxSize; i++)
            str.append(queArray[i].toString()).append(" ");
        return str.toString();
    }
}
