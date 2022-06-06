package com.hyb.ds.图;

import sun.misc.Queue;

import java.util.Enumeration;

public class DirectedCycle {
    //标记路是否走过(大循环)
    private boolean[] marked;
    //标记是否有环路
    private boolean hasCycle;
    //辅助数组,下标对应节点,值对应是否被访问过(监测环的小循环)
    private boolean[] directed;

    public DirectedCycle(Graph graph){
        int v = graph.getV();
        this.marked=new boolean[v];
        this.directed=new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!marked[i]){
                dfs(graph,i);
            }
        }

    }

    private void dfs(Graph graph,int first){
        marked[first]=true;

        directed[first]=true;

        Queue<Integer> e = graph.getE(first);

        Enumeration<Integer> elements = e.elements();
        while (elements.hasMoreElements()){
            Integer integer = elements.nextElement();
            if (!marked[integer]){
                dfs(graph,integer);
            }
            //如果在小循环里发现,该点已经被访问过了,说明存在一个环
            if (directed[integer]){
                hasCycle=true;
                return;
            }
        }

        directed[first]=false;
    }


    public boolean isHasCycle(){
        return hasCycle;
    }

}
