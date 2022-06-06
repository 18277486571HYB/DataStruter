package com.hyb.ds.图;

import sun.misc.Queue;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class PrimMST {
    //保存现有的最短路径
    private List<EdgeW> edgeTo;
    //索引代表顶点,判断该顶点是否已经在树中
    private boolean[] marked;
    //存放切分的有效横切边,索引是与该点的最近相连的点(不是当前点),值是这个边对象
    private EdgeW[] pq;

    public PrimMST(WeightGraph graph) throws InterruptedException {
        int v = graph.getV();
        edgeTo =new ArrayList<>();
        marked=new boolean[v];
        pq =new EdgeW[v];
        visit(graph,0);
    }

    public void visit(WeightGraph graph,int v) throws InterruptedException {

        //创建分割点的队列
        Queue<Integer> queue=new Queue<>();
        //第一次让第一个点进来
        queue.enqueue(v);
        //当这个队列不为空
        while (!queue.isEmpty()){
            //吐出队列中先进入的点
            Integer dequeue = queue.dequeue();
            //标记该点已经被访问过了
            marked[dequeue]=true;
            //获取该点所有直连的点的队列
            Queue<EdgeW> edges = graph.getEdges(dequeue);
            //遍历该队列,找到与其最小路径的点
            Enumeration<EdgeW> elements = edges.elements();

            while (elements.hasMoreElements()){
                //找到某条边
                EdgeW edgeW = elements.nextElement();
                //获取当前点在这条边上对应的点
                int other = edgeW.other(dequeue);
                //如果这点已经在过去被当成dequue点了,就直接跳过
                if (marked[other])
                    continue;
                //如果这个点延伸出的边本来就在pq数组中
                if (pq[other]==null){
                    //如果other延伸出的边不在数组中,就直接加入进入
                    pq[other]=edgeW;
                }else {
                    //就比较当前other点延伸出的边比原来的是否小
                    if (edgeW.getWeight() < pq[other].getWeight()) {
                        //如果当前边的权重比本来存在的边的权重要小,就代替它
                        pq[other] = edgeW;
                    }
                }
            }
            //根据得到的pq数组中找一条最小的边
            int j = findMinW(pq);
            //回到原点就不用再入队了
            if (j!=0){
                queue.enqueue(j);
            }

        }
    }

    private int findMinW(EdgeW[] pq) {
        EdgeW x=new EdgeW(0,0,Double.MAX_VALUE);
        int j=0;
        for (int i = 1; i < pq.length; i++) {
            if (pq[i]!=null){
                if (pq[i].getWeight()<x.getWeight()){
                    x=pq[i];
                    j=i;
                }
            }
        }

        //防止回到原点的时候将list集合里的东西
        // 代替了
        if (j!=0){
            int first = x.other(j);
            edgeTo.add(new EdgeW(first,j,x.getWeight()));
            //将最小边从数组记录里移除
            pq[j]=null;
        }
        return j;
    }

    public List<EdgeW> getEdges(){
        return edgeTo;
    }
}
class Test5{
    public static void main(String[] args) throws InterruptedException {
        WeightGraph weightGraph = new WeightGraph(8, false);
        EdgeW edgeW = new EdgeW(0, 2, 0.26);
        EdgeW edgeW1 = new EdgeW(0, 7, 0.16);
        EdgeW edgeW2 = new EdgeW(0, 4, 0.38);
        EdgeW edgeW3 = new EdgeW(0, 6, 0.58);
        EdgeW edgeW4 = new EdgeW(6, 2, 0.40);
        EdgeW edgeW7 = new EdgeW(6, 3, 0.52);
        EdgeW edgeW8 = new EdgeW(6, 4, 0.93);
        EdgeW edgeW5 = new EdgeW(2, 7, 0.34);
        EdgeW edgeW6 = new EdgeW(2, 3, 0.17);
        EdgeW edgeW9 = new EdgeW(2, 1, 0.36);
        EdgeW edgeW11 = new EdgeW(7, 4, 0.37);
        EdgeW edgeW12 = new EdgeW(7, 5, 0.28);
        EdgeW edgeW13 = new EdgeW(7, 1, 0.19);
        EdgeW edgeW18 = new EdgeW(7, 2, 0.34);
        EdgeW edgeW14 = new EdgeW(5, 1, 0.32);
        EdgeW edgeW15 = new EdgeW(5, 4, 0.35);
        EdgeW edgeW16 = new EdgeW(1, 3, 0.29);
        weightGraph.addEdge(edgeW);
        weightGraph.addEdge(edgeW7);
        weightGraph.addEdge(edgeW8);
        weightGraph.addEdge(edgeW9);
        weightGraph.addEdge(edgeW11);
        weightGraph.addEdge(edgeW12);
        weightGraph.addEdge(edgeW13);
        weightGraph.addEdge(edgeW18);
        weightGraph.addEdge(edgeW14);
        weightGraph.addEdge(edgeW15);
        weightGraph.addEdge(edgeW16);
        weightGraph.addEdge(edgeW1);
        weightGraph.addEdge(edgeW2);
        weightGraph.addEdge(edgeW3);
        weightGraph.addEdge(edgeW4);
        weightGraph.addEdge(edgeW5);
        weightGraph.addEdge(edgeW6);
        PrimMST primMST = new PrimMST(weightGraph);
        List<EdgeW> edges = primMST.getEdges();
        for (EdgeW e :
                edges) {
            System.out.println(e.toString());
        }

    }
}
