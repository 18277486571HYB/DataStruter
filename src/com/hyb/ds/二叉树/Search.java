package com.hyb.ds.二叉树;

import java.util.ArrayList;
import java.util.List;

public class Search {

    private List<Integer> list=new ArrayList<>();

    private Node headNode;

    private int modCount;

//    树结构
    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int v,Node l,Node r){
            this.value=v;
            this.left=l;
            this.right=r;
        }

    }

    public void setHeadNode(Node node){
        this.headNode=node;
    }

    //前序遍历
    public List<Integer> forwardFind(Node node){

        list.add(node.value);

        if (node.left!=null){
            forwardFind(node.left);
        }
        if (node.right!=null){
            forwardFind(node.right);
        }
        return this.list;
    }

    //中序遍历
    public List<Integer> midleFind(Node node){
        if (node.left!=null){
            midleFind(node.left);
        }
        list.add(node.value);
        if (node.right!=null){
            midleFind(node.right);
        }
        return list;
    }

    //后序遍历
    public List<Integer> reverFind(Node node){
        if (node.left!=null){
            reverFind(node.left);
        }
        if (node.right!=null){
            reverFind(node.right);
        }
        list.add(node.value);
        return list;
    }

    //删除节点
//    public void delNode(Node node,int value) {
//
//        if (node.value==value){
//            node=null;
//            return ;
//        }
//        if (node.left!=null){
//            delNode(node.left,value);
//        }
//        if (node.right!=null){
//            delNode(node.right,value);
//        }
//    }
    //
    public void del(Node node,int value){
        if (node.left!=null){
            if (node.left.value==value) {
                node.left = null;
                return;
            }
            del(node.left,value);
        }
        if (node.right!=null){
            if (node.right.value==value){
                node.right=null;
                return;
            }
            del(node.right,value);
        }
    }

    public List<Integer> ArraySearch(int[] a){
        return ArraySearch(0,a);
    }

    //前序遍历二叉树数组
    private List<Integer> ArraySearch(int index,int[] a){
        if (a.length == 0){
            return list;
        }
        list.add(a[index]);
        if (index*2+1<a.length){
            //左子树遍历
            ArraySearch(index*2+1,a);
        }
        if (index*2+2<a.length){
            ArraySearch(index*2+2,a);
        }
        return list;
    }

    public void put(int value){
        if (headNode==null){
            System.out.println("根节点为空");
            return;
        }
        put(headNode,value);
        modCount=0;
    }

    private void put(Node node, int value) {

        if (node.value==value || modCount==1)
            return;
        if (node.left==null && value<node.value){
            node.left= new Node(value, null, null);
            modCount++;
        }
        if (node.right==null && value> node.value){
            node.right=new Node(value,null,null);
            modCount++;
        }
        if (node.left!=null){
            put(node.left,value);
        }
        if (node.right!=null){
            put(node.right,value);
        }

    }

}

class Test{
    public static void main(String[] args) {
        Search.Node nodel1 = new Search.Node(2,null,null);
        Search.Node nodel2 = new Search.Node(31,null,null);
        Search.Node noder3 = new Search.Node(35,null,null);
        Search.Node noder4 = new Search.Node(47,null,null);
        Search.Node nodel = new Search.Node(30,nodel1,nodel2);
        Search.Node noder = new Search.Node(36,noder3,noder4);
        Search.Node node = new Search.Node(32, nodel, noder);
        Search search = new Search();
        search.setHeadNode(node);
//        List<Integer> integers = search.reverFind(node);
//        for (Integer i :
//                integers) {
//            System.out.println(i);
//        }
//        search.del(node, 2);
            search.put(4);
            search.put(5);
        List<Integer> integers = search.forwardFind(node);
        for (Integer integer:integers
             ) {
            System.out.println(integer);
        }
//        int[ ] a=new int[]{2,31,35,47,30,36,32};
//        List<Integer> integers1 = search.ArraySearch(a);
//        System.out.println("==========");
//        for (Integer integer:integers1){
//            System.out.println(integer);
//        }


    }
}
