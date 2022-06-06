package com.hyb.ds.图;


import sun.misc.Queue;

import java.util.Enumeration;

public class BFS {
    private boolean[] marked;
    private int count;
    //辅助队列
    private Queue<Integer> queues;

    public BFS(Graph graph,int first) throws InterruptedException {
        marked=new boolean[graph.getV()];
        this.count=0;
        queues=new Queue<Integer>();
        bfs(graph,first);
    }

    public void bfs(Graph graph,int first) throws InterruptedException {
        marked[first]=true;
        queues.enqueue(first);
        while (!queues.isEmpty()){
            Integer dequeue = queues.dequeue();
            Queue<Integer> e = graph.getE(dequeue);
            Enumeration<Integer> elements = e.elements();
            while (elements.hasMoreElements()){
                Integer element = elements.nextElement();
                if (!marked[element]){
                    queues.enqueue(element);
                    marked[element]=true;
                }
            }
            System.out.println("搜索点->"+dequeue);
            count++;
        }
    }

    //判断某点是否与顶点相通
    public boolean marked(int w){
        return marked[w];
    }

    public int getCount(){
        return count;
    }
}
class Test1{
    public static void main(String[] args) throws InterruptedException {
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
        BFS dfs = new BFS(graph, 0);
        System.out.println(dfs.getCount());
        System.out.println(dfs.marked(7));
        System.out.println(dfs.marked(6));
        System.out.println(dfs.marked(3));
    }
}
class Test2{
    public static void main(String[] args) throws InterruptedException {
        Graph graph = new Graph(20);
        graph.addE(0,1);
        graph.addE(6,9);
        graph.addE(3,8);
        graph.addE(5,11);
        graph.addE(2,12);
        graph.addE(6,10);
        graph.addE(4,8);
        BFS dfs = new BFS(graph, 9);
        System.out.println(dfs.getCount());
        System.out.println(dfs.marked(8));
        System.out.println(dfs.marked(10));
    }
}
