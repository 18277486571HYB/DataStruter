package com.hyb.ds.图;

import com.hyb.ds.并查集.UF;

import java.util.*;

public class Kruskal {
    private Set<EdgeW> set;

    private UF uf;

    public Kruskal(WeightGraph graph){

        set=new HashSet<>();
        Set<EdgeW> edges = graph.edges();
        int size = edges.size();
        int v = graph.getV();
        uf=new UF(v);
        for (int i = 0; i < size; i++) {
            kruskal(edges);
        }

    }

    private void kruskal(Set<EdgeW> edges) {

        Iterator<EdgeW> iterator = edges.iterator();
        EdgeW edgeW=new EdgeW(-1,-1,Double.MAX_VALUE);
        while (iterator.hasNext()){
            EdgeW w = iterator.next();
            if (w.getWeight()<edgeW.getWeight()){
                edgeW=w;
            }
        }
        int w = edgeW.getW();
        int v = edgeW.other(w);
        if (!uf.connected(w,v)){
            uf.unioned(w,v);
            set.add(edgeW);
        }
        edges.remove(edgeW);
    }

    public Set<EdgeW> getSet(){
        return set;
    }
}
class Test6{
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
        Kruskal kruskal = new Kruskal(weightGraph);
        Set<EdgeW> set = kruskal.getSet();
        for (EdgeW next : set) {
            System.out.println(next.toString());
        }

    }
}