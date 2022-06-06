package com.hyb.ds.图;

import com.hyb.ds.队列.ArrayQueue;
import sun.misc.Queue;

import java.util.Enumeration;

public class DFS {
    private boolean[] marked;
    //初始化跟顶点相通的数量
    private int count;

    public DFS(Graph graph,int first){
        this.marked=new boolean[graph.getV()];
        this.count=0;
        dfs(graph,first);
    }

    public void dfs(Graph graph,int first){
        marked[first]=true;
        Queue<Integer> e = graph.getE(first);
        Enumeration<Integer> elements = e.elements();

        while (elements.hasMoreElements()){
            Integer integer = elements.nextElement();
            if (!marked(integer)){
                System.out.println("搜索点->"+integer);
                dfs(graph,integer);
            }

        }

        count++;

    }

    //判断某点是否与顶点相通
    public boolean marked(int w){
        return marked[w];
    }

    public int getCount(){
        return count;
    }
}
