package com.hyb.ds.链表.双向链表;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedList<E> {

    private final Node<E> head=new Node<E>(null,0);

    private static Integer size=0;

    private Node<E> node(E data, Integer sort){
        return new Node<E>(data,sort, null, null);
    }

    private Node<E> node(E data, Integer sort,Node<E> pre,Node<E> next){
        return new Node<E>(data,sort, pre, next);
    }

    private boolean isEmpty(Node<E> node){
        return node==null;
    }

    //尾插法
    public void append(E data){
        Node<E> head = this.head;
        Node<E> node = node(data,size+1);
        if (isEmpty(head.next)){
            head.next=node;
            node.pre=head;
            size++;
            return;
        }
        while (head.next!=null)
            head=head.next;
        head.next=node;
        node.pre=head;
        size++;
    }
    //头插法
    public void appendHead(E data){
        Node<E> head = this.head;
        Node<E> node = node(data,size+1);


        Node<E> first = head.next;

        node.next=first;
        if (first!=null){
            first.pre=node;
        }

        head.next=node;
        node.pre=head;

        size++;
    }

    //中间插入一个节点
    public void appendMiddle(Integer index,E data){
        if (!isIndex(index))
            return;

        Node<E> head = this.head;
        Node<E> node = node(data, size + 1);
        if (isEmpty(head.next)){
            head.next=node;
            node.pre=head;
            return;
        }
        for (int i = 1; i <= size; i++) {
            head=head.next;
            if (i==index){
                head.pre.next=node;
                node.pre=head.pre;
                head.pre=node;
                node.next=head;
                break;
            }
        }
        size++;
    }
    //删除一个节点
    public void delNode(Integer index){
        if (!isIndex(index)||isEmpty(head.next))
            return;
        Node<E> head = this.head;
        for (int i = 1; i <= size; i++) {
            head=head.next;
            if (i==index){
                head.pre.next=head.next;
                head.next.pre=head.pre;
                break;
            }
        }
        size--;
    }


    private boolean isIndex(Integer index){
        return index>0&&index<=size;
    }

    //遍历数据
    public List<E> list(){
        Node<E> head = this.head.next;
        List<E> list=new ArrayList<>();
        for (Node<E> node=head;node!=null;node=node.next){
            list.add(node.data);
        }
        return list;
    }



    private static class Node<E>{
        E data;
        Integer sort;
        Node<E> pre;
        Node<E> next;

        public Node(E data, Integer sort) {
            this.data = data;
            this.sort = sort;
        }

        public Node(E data, Integer sort, Node<E> pre, Node<E> next) {
            this.data = data;
            this.sort = sort;
            this.pre = pre;
            this.next = next;
        }
    }
}
class Test{
    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            doubleLinkedList.append(i);
        }
        System.out.println("测试尾插法:");
        List<Integer> list = doubleLinkedList.list();
        list.forEach(System.out::println);
        System.out.println("测试头插法:");
        DoubleLinkedList<Integer> integerDoubleLinkedList = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            integerDoubleLinkedList.appendHead(i);
        }
        List<Integer> list1 = integerDoubleLinkedList.list();
        list1.forEach(System.out::println);
        System.out.println("测试中间插入:");
        integerDoubleLinkedList.appendMiddle(1,1111);
        List<Integer> list2 = integerDoubleLinkedList.list();
        list2.forEach(System.out::println);
        System.out.println("测试删除一个节点:");
        integerDoubleLinkedList.delNode(1);
        List<Integer> list3 = integerDoubleLinkedList.list();
        list3.forEach(System.out::println);
    }
}