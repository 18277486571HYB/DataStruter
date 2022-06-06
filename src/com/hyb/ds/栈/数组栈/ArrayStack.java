package com.hyb.ds.栈.数组栈;

public class ArrayStack {

    private final Object[] data;
    private int top;

    public ArrayStack(int size) {
        this.data =  new Integer[size];
        this.top = -1;
    }

    //判断栈满
    public boolean isFull(){
        return top==data.length;
    }
    //判断栈空
    public boolean isEmpty(){
        return top==-1;
    }
    //入栈
    public void push(Object value){
        if (isFull())
            return;
        data[++top]=value;
    }
    //出栈
    public Object pop(){
        if (isEmpty())
            return null;
        return data[top--];
    }
    //返回栈高度
    public int size(){
        return data.length;
    }

    //遍历栈
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (Object datum : data) {
            s.append(datum).append(" ");
        }
        return s.toString();
    }


}

class Test{
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        System.out.println("入栈");
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
        }
        System.out.println("出栈:");
        for (int i = 0; i < 10; i++) {
            System.out.print(arrayStack.pop()+" ");
        }
        System.out.println("遍历栈:");
        System.out.println(arrayStack);

    }
}
