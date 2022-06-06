package com.hyb.ds.队列;

/*
* 环形队列
* */
public class CircleQueue {
    private final Object[] queue;
    private int front;
    private int rear;

    private final int capacity;

    public CircleQueue(int capacity){
        this.capacity = capacity;
        this.queue = new Object[capacity];
        this.front = 0;
        this.rear = 0;

    }

    public void insertQueue(Object value){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        queue[rear]=value;
        rear=(rear+1)%capacity;
    }
    public Object popQueue(){
        if (isEmpty()){
            System.out.println("队列已空");
            throw new RuntimeException("队列已空");
        }
        Object o = queue[front];
        front=(front+1)%capacity;
        return o;
    }

    public boolean isEmpty() {
        return front==rear;
    }


    public boolean isFull(){
        return (rear+1)%capacity==front;
    }




}
