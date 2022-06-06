package com.hyb.ds.二叉树;

import sun.misc.Queue;

import java.util.List;

public class PageTree {

    private static Node head;

    public static class Node<T>{
        T item;
        Node<T> left;
        Node<T> right;
        public Node(T item,Node<T> left,Node<T>right){
            this.item=item;
            this.left=left;
            this.right=right;
        }
    }

    public static Node<String> create(int n) throws InterruptedException {
        Node<String> root=null;
        for (int i = 0; i < n; i++) {
            if (i==0){
                root=new Node<>("down",null,null);
                continue;
            }
            Queue<Node<String>> nodeQueue = new Queue<>();
            nodeQueue.enqueue(root);
            while (!nodeQueue.isEmpty()){
                Node<String> deNode = nodeQueue.dequeue();
                if (deNode.left!=null){
                    nodeQueue.enqueue(deNode.left);
                }
                if (deNode.right!=null){
                    nodeQueue.enqueue(deNode.right);
                }
                if (deNode.left==null&&deNode.right==null){
                    deNode.left=new Node<>("down",null,null);
                    deNode.right=new Node<>("up",null,null);
                }
            }

        }
        return root;
    }

    public static void print(Node<String> node){
        System.out.println(node.item);
        if (node.left!=null){
            print(node.left);
        }
        if (node.right!=null){
            print(node.right);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Node<String> stringNode = PageTree.create(3);
        PageTree.print(stringNode);
    }
}
