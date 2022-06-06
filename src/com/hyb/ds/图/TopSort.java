package com.hyb.ds.图;

import com.hyb.ds.二叉树.PageTree;
import com.hyb.ds.设计模式.代理模式.动态代理.TargetObj;
import sun.misc.Queue;

import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

public class TopSort {
    //是否被访问过
    private boolean[] marked;
    //递归完毕后将节点反向存入栈中
    private Stack<Integer> stack;
    //存储可达路径
    private List<Stack<Integer>> list;

    private boolean flag;

    public TopSort(Graph graph){
        int v = graph.getV();
        marked=new boolean[v];
        stack=new Stack<>();
        //因为是有向图,所有要循环所有顶点
        for (int i = 0; i < 2; i++) {
            if (!marked[i]){
                dfs(graph,i);
            }
        }
    }

    private void dfs(Graph graph,int first){
        marked[first]=true;
        //深度优先完毕后让顶点入栈

        System.out.println("入栈点->"+first);
        Queue<Integer> e = graph.getE(first);
        Enumeration<Integer> elements = e.elements();
        while (elements.hasMoreElements()){
            flag=false;
            Integer integer = elements.nextElement();
            if (!marked[integer]){
                dfs(graph,integer);
//                if (!flag ){
//
//                }
           }
        }
        stack.push(first);
//        stack.pop();
//        marked[first]=false;
    }

    public Stack<Integer> getStack(){
        return stack;
    }

    public List<Stack<Integer>> list(){
        return list;
    }
}
