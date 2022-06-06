package com.hyb.ds.链表.单向链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SingleLinkedList<E> {

    private final Node<E> head=new Node<>(null,-1,null);


    private static Integer size=0;

    private Integer index(Integer size){
        return size;
    }

    private Node<E> node(E data){
        return new Node<>(data,index(size+1), null);
    }




    //尾插法
    public void append(E data){
        Node<E> newNode = node(data);
        Node<E> headNode=head;
        while (headNode.next != null) {
            headNode = headNode.next;
        }
        headNode.next=newNode;
        size++;
    }

    //头插法
    public void linkedHead(E data){
        Node<E> node = node(data);
        linkedHeadByNode(head,node);
        size++;
    }

    private void linkedHeadByNode(Node<E> head,Node<E> node){
        if (isEmpty(head)){
            head.next=node;
            head.next.next=null;
            return;
        }
        Node<E> firstNode = head.next;
        head.next=node;
        node.next=firstNode;

    }

    //指定位置插入
    public void appendForIndex(Integer index,E data){

        if (!isLegal(index))
            return;

        Node<E> head = this.head;
        Node<E> node = node(data);

        for (int i = 1; i <= size; i++) {
            //如果到了最后一个节点
            if (isEmpty()){
                head.next=node;
            }
            if (i==index){
                addLinked(head,head.next,node);
                break;
            }
            head=head.next;
        }
    }

    private boolean isLegal(Integer index) {
        return index>-1&&index<=size;
    }


    private void addLinked(Node<E> head,Node<E> last,Node<E> node){
        head.next=node;
        node.next=last;
        size++;
    }

    //删除一个节点
    public void delNode(Integer sort){
        Node<E> head = this.head;
        if (isEmpty()||(!isLegal(sort)))
            return;
        for (Node<E> h=head.next;h.next!=null;h=h.next){
            //如果当前节点的下一个节点与sort相同,就删除下一个节点
            if (sort.equals(h.next.sort)){
                //将当前节点和下一个节点传入
                removeLinked(h,h.next);
                break;
            }
        }
    }
    //查找某个位置的节点
    public E getValue(Integer sort){
        if (isEmpty()||(!isLegal(sort)))
            return null;
        Node<E> head = this.head;
        for (Node<E> h=head.next;h.next!=null;h=h.next) {
            if (sort.equals(h.sort)){
                return h.data;
            }
        }
        return null;
    }

    //查找倒数第k位的节点
    public E getReversalValue(Integer sort){
        if (isEmpty()||(!isLegal(sort)))
            return null;
        Node<E> head=this.head;
        for (int i = 0; i <= size - sort; i++) {
            head=head.next;
            if ((size-sort+1)==head.sort)
                return head.data;
        }
        return null;
    }

    private void removeLinked(Node<E> h,Node<E> next) {
        //如果下一个节点是最后一个节点
        if (next.next==null){
            //让当前节点为最后一个节点
            h.next=null;
            return;
        }
        //如果下一个节点不是最后一个节点
        h.next=next.next;
        size--;

    }

    public void delNodeByData(E data){
        Node<E> head = this.head;
        if (isEmpty()){
            return;
        }
        for (Node<E> x=head.next;x.next!=null;x=x.next){
            if (data.equals(x.next.data)){
                removeLinked(x,x.next);
                break;
            }
        }
    }


    public List<E> list(){
        if (isEmpty())
            return null;
        Node<E> headNode=head;
        List<E> list=new ArrayList<>();
        while (headNode.next!=null){
            headNode=headNode.next;
            list.add(headNode.data);
        }
        return list;
    }

    public boolean isEmpty(){
        return head.next==null;
    }

    public boolean isEmpty(Node<E> head){
        return head.next==null;
    }

//    链表翻转
    public void reverseNode(){
        if (isEmpty()||head.next.next==null)
            return;
        //拿到头节点
        Node<E> head = this.head;
        //新建头结点
        Node<E> newHead = new Node<E>(null,0,null);

        Node<E> next=null;

        while (head.next!=null){

            next=head.next.next;


            Node<E> p1 = head.next;

            p1.next=newHead.next;

            newHead.next=p1;


            head.next=next;
        }

        //让原头结点指向新头结点的下一个,即新链表的第一个节点
        this.head.next=newHead.next;
    }

    public void reverse(){
        if (isEmpty()||head.next.next==null)
            return;
        //辅助执行,指向第一个节点
        Node<E> p=head.next;
        //定义中间变量next,防止head.next被篡改,得到p的下一个节点
        Node<E> next=null;
        //定义一个新的链表
        Node<E> newNode=new Node<>(null,0,null);

        while (p!=null){
            //先保存p的下一个节点,防止p中间被修改无法获取p.next
            next=p.next;
            //断开p与后面的所有节点
            p.next=newNode.next;
            //让新的头节点指向p
            newNode.next=p;
            //p向后移
            p=next;
        }
        //让老头节点指向新的头节点后的第一个节点
        head.next=newNode.next;

    }

    //单链表反向打印
    public List<E> reverseList(){
        //拿到第一个节点
        Node<E> p = head.next;
        //创建一个栈
        Stack<E> stack = new Stack<>();
        //遍历单链表
        for (Node<E> p1=p;p1!=null;p1=p1.next){
            //入栈
            stack.push(p1.data);
        }
        return new ArrayList<>(stack);
    }

    //两个升序链表合成一个升序链表
    public SingleLinkedList<E> mergeNode(SingleLinkedList<E> e1,SingleLinkedList<E> e2){
        Node<E> p1 = e1.head.next;
        Node<E> p2 = e2.head.next;
        SingleLinkedList<E> newLinkedList = new SingleLinkedList<>();
        Node<E> p3 = newLinkedList.head;
        //如果p1为空,将p2链接到p3尾部
        if (p1==null&&p2!=null){
            p3.next=p2;
            return newLinkedList;

        //反之将p1链接到p3尾部
        }else if(p1!=null&&p2==null){
            p3.next=p1;
            return newLinkedList;
        }

        while (p1!=null&&p2!=null){
            E d1 = p1.data;
            E d2 = p2.data;
            if (d1 instanceof Integer && d2 instanceof Integer){
                //如果p1所在节点的值小于p2所在节点的值
                if ((Integer)d1<(Integer) d2){
                    //将p1节点值放入p3
                    p3.next=p1;
                    //p1后移
                    p1=p1.next;
                //相反情况
                }else if ((Integer)d1>(Integer) d2){
                    p3.next=p2;
                    p2=p2.next;
                //如果两个值相等,两个指针都向后移动
                }else {
                    p3.next=p1;
                    p1=p1.next;
                    p2=p2.next;
                }
                //p3后移
                p3=p3.next;
            }else
                throw new RuntimeException("不支持该类型比较");

            //如果某个链表先遍历完,将剩下的没遍历的链表直接套在p3后
            if (p1==null||p1.next==null){
                p3.next=p2;
            }
            if (p2==null||p2.next==null){
                p3.next=p1;
            }
        }
        return newLinkedList;
    }

    static class Node<E>{
        E data;
        Integer sort; //插入顺序
        Node<E> next;

        public Node(E data,Integer sort,Node<E> next) {
            this.data = data;
            this.sort=sort;
            this.next=next;
        }
    }
}

class Test{

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.append(i);
        }
        List<Integer> list1 = linkedList.list();
        list1.forEach(System.out::println);
        //测试头插法
        linkedList.linkedHead(111);
        System.out.println("=============");
        List<Integer> list2 = linkedList.list();
        list2.forEach(System.out::println);
        //测试指定位置插入
        linkedList.appendForIndex(1,222);
        System.out.println("=============");
        List<Integer> list3 = linkedList.list();
        list3.forEach(System.out::println);
        //测试删除一个节点
        linkedList.delNode(1);
        System.out.println("============");
        List<Integer> list = linkedList.list();
        list.forEach(System.out::println);
        //测试删除一个节点
        linkedList.delNodeByData(3);
        System.out.println("============");
        List<Integer> list4 = linkedList.list();
        list4.forEach(System.out::println);
        //按照插入顺序查找
        Integer value = linkedList.getValue(2);
        System.out.println("============");
        System.out.println(value);
        //查找插入顺序倒数的值
        Integer reversalValue = linkedList.getReversalValue(1);
        System.out.println("============");
        System.out.println(reversalValue);
        //测试链表翻转
        linkedList.reverseNode();
        System.out.println("===========");
        List<Integer> list5 = linkedList.list();
        list5.forEach(System.out::println);

        //反向打印单链表
        List<Integer> reverseList = linkedList.reverseList();
        System.out.println("=============");
        reverseList.forEach(System.out::println);

        System.out.println("--------------------------");
        SingleLinkedList<Integer> p1 = new SingleLinkedList<>();
        SingleLinkedList<Integer> p2 = new SingleLinkedList<>();
        p1.append(1);
        p1.append(77);
        p1.append(9900);
        p2.append(30);
        p2.append(633);
        p2.append(899);

        List<Integer> list7 = p1.list();
        System.out.print("p1:");
        list7.forEach(System.out::print);
        System.out.println();
        System.out.print("p2:");
        List<Integer> list8 = p2.list();
        list8.forEach(System.out::print);
        System.out.println();
        System.out.println("反转后");

        SingleLinkedList<Integer> p3= new SingleLinkedList<>();
        SingleLinkedList<Integer> integerSingleLinkedList = p3.mergeNode(p1, p2);

        List<Integer> list6 = integerSingleLinkedList.list();
        list6.forEach(System.out::println);


    }
}
