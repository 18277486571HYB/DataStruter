package com.hyb.ds.链表.单向环形链表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SingleCircleLinkedList<E> {

    private final Node<E> head=new Node<>(null,0,null);

    //创建环形链表
    public void createLinkedList(E ...value){

        Node<E> head = this.head;
        Node<E> last=null;
        for (int i = 0; i < value.length; i++) {
            if (i==0){
                head.data=value[0];
                last=head;
                continue;
            }
            Node<E> eNode = new Node<>(value[i], i, null);
            head.next= eNode;
            head=head.next;
            if (i== value.length-1){
                last=eNode;
            }
        }

        if (last != null) {
            last.next=this.head;
        }

    }
    //遍历环形链表
    public List<E> list(){
        Node<E> head = this.head;
        List<E> list=new ArrayList<>();
//        for循环头节点遍历不出来,我也不知道为啥
        list.add(head.data);
        for (Node<E> node=head.next;node!=head;node=node.next){
            list.add(node.data);
            System.out.println("node.data="+node.data);
            System.out.println("node.next.data="+node.next.data);
            System.out.println("head.data="+head.data);
        }
//        while (true){
//            list.add(head.data);
//            if (head.next==this.head)
//                break;
//            head=head.next;
//        }
        return list;
    }

    //约瑟夫问题 有n个人,从k开始数起,数到m断开节点,下一个人从1开始数,规则一样
    public int[] josePhu(int n,int k,int m){
        if (head.data==null || k>n || m>n){
            return null;
        }
        Node<E> p1 = this.head;
        Node<E> p2=this.head;
        int[] count=new int[n];
        int cnt=0;
        if (k==1){
            for (int i=1;i<n;i++)
                p2=p2.next;
        }else {
            for (int i=1;i<k;i++){
                p1=p1.next;
                //p2需要少循环一次
                if (i==k-1)
                    break;
                p2=p2.next;
            }
        }
        while (n != 0) {
            //从当前节点开始数,数到m,将两个指针移动到对的位置
            for (int i = 0; i < m-1; i++) {
                p1=p1.next;
                p2=p2.next;
            }
            E data = p1.data;
            p1 = p1.next;
            p2.next = p1;
            if (data instanceof Integer) {
                count[cnt++] = (Integer) data;
                n--;
            }
        }
        return count;

    }

    private static class Node<E>{
        E data;
        int sort;
        Node<E> next;

        public Node(E data, Integer sort, Node<E> next) {
            this.data = data;
            this.sort = sort;
            this.next = next;
        }
    }
}

class Test{
    public static void main(String[] args) {
        SingleCircleLinkedList<Integer> circleLinkedList = new SingleCircleLinkedList<>();
        circleLinkedList.createLinkedList(3,5,7,8,1,2);
        List<Integer> list = circleLinkedList.list();
        list.forEach(System.out::println);
        System.out.println("约瑟夫问题测验:");
        int[] ints = circleLinkedList.josePhu(6, 2, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
