package com.hyb.ds.图;

import java.util.List;
import java.util.Stack;

public class TopoSort {
    private Stack<Integer> stack;

    private List<Stack<Integer>> list;

    public TopoSort(Graph graph){
        DirectedCycle directedCycle = new DirectedCycle(graph);
        boolean hasCycle = directedCycle.isHasCycle();
        if (!hasCycle){
            TopSort topSort = new TopSort(graph);
            stack=topSort.getStack();
            list=topSort.list();
        }
    }

    public boolean isCycle(){
        return stack==null;
    }

    public Stack<Integer> getStack(){
        return stack;
    }

    public List<Stack<Integer>> getList() {
        return list;
    }
}
class Test4{
    public static void main(String[] args) {
        Graph graph = new Graph(6, true);
        graph.addE(0,2);
        graph.addE(0,3);
        graph.addE(1,3);
        graph.addE(2,4);
        graph.addE(3,4);
        graph.addE(4,5);

        TopoSort topoSort = new TopoSort(graph);
        Stack<Integer> stack = topoSort.getStack();
        for (Integer i :
                stack) {
            System.out.println(i);
        }
//        List<Stack<Integer>> list = topoSort.getList();
//        System.out.println(list.toString());

    }
}
