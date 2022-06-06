package com.hyb.ds.图;

import sun.misc.Queue;

import java.awt.*;
import java.util.Enumeration;

public class Graph {
    //点
    private final int v;
    //边
    private int e;
    //是否是有向图
    private boolean marked;
    //保存各个点的直连点队列
    private final Queue<Integer>[] queues;

    public Graph(int v){
        this.v=v;
        this.e=0;
        queues= new Queue[v];
        for (int i = 0; i < v; i++) {
            queues[i]= new Queue<Integer>();
        }
    }
    public Graph(int v,boolean type){
        this.v=v;
        this.e=0;
        this.marked=type;
        queues= new Queue[v];
        for (int i = 0; i < v; i++) {
            queues[i]= new Queue<Integer>();
        }
    }

    public int getV(){
        return v;
    }
    public int getE(){
        return e;
    }

    public void addE(int w,int m){
        queues[w].enqueue(m);
        if (!marked){
            queues[m].enqueue(w);
        }
        e++;
    }

    public Queue<Integer> getE(int i){
        return queues[i];
    }

    private Graph reverseGraph(){
        Graph graph = new Graph(v);
        for (int i = 0; i < v; i++) {
            Queue<Integer> e = getE(i);
            Enumeration<Integer> elements = e.elements();
            while (elements.hasMoreElements()){
                Integer integer = elements.nextElement();
                addE(integer,i);
            }
        }
        return graph;
    }

}

class Test{
    public static void main(String[] args) {
        Graph graph = new Graph(13);
        graph.addE(0,1);
        graph.addE(0,2);
        graph.addE(0,6);
        graph.addE(0,5);
        graph.addE(5,3);
        graph.addE(5,4);
        graph.addE(3,4);
        graph.addE(4,6);
        graph.addE(7,8);
        graph.addE(9,10);
        graph.addE(9,11);
        graph.addE(9,12);
        graph.addE(11,12);
        DFS dfs = new DFS(graph, 0);
        System.out.println(dfs.getCount());
        System.out.println(dfs.marked(7));
        System.out.println(dfs.marked(6));
        System.out.println(dfs.marked(3));
    }
}
