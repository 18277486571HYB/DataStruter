package com.hyb.ds.图;

import sun.misc.Queue;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class WeightGraph {

    //顶点
    private int v;

    //边
    private int e;

    private Queue<EdgeW>[] edgeQueues;

    private boolean type;

    public WeightGraph(int v,boolean type) {
        this.v = v;
        this.edgeQueues = new Queue[v];
        this.type = type;
        for (int i = 0; i < v; i++) {
            edgeQueues[i]=new Queue<EdgeW>();
        }
    }

    public int getV(){
        return v;
    }

    public int getW(){
        return e;
    }

    public void addEdge(EdgeW edge){
        int w = edge.getW();
        int v = edge.getV();
        edgeQueues[w].enqueue(edge);
        if (!type){
            edgeQueues[v].enqueue(edge);
        }
        e++;
    }

    //获取和顶点v关联的所有边
    public Queue<EdgeW> getEdges(int v){
        return edgeQueues[v];
    }

    //获取所有边
    public Set<EdgeW> edges(){
        HashSet<EdgeW> edgeWS = new HashSet<>();
        for (int i = 0; i < this.v; i++) {
            Queue<EdgeW> edges = getEdges(i);
            Enumeration<EdgeW> elements =
                    edges.elements();
            while (elements.hasMoreElements()){
                EdgeW edgeW = elements.nextElement();
                edgeWS.add(edgeW);
            }
        }

        return edgeWS;
    }


}
