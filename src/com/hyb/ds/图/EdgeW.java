package com.hyb.ds.图;

public class EdgeW implements Comparable {
    private int w;
    private int v;
    private double weight;

    public EdgeW(int w, int v, double weight){
        this.w=w;
        this.v=v;
        this.weight=weight;
    }

    public double getWeight() {
        return weight;
    }

    public int getW() {
        return w;
    }

    public int getV() {
        return v;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof EdgeW){
            EdgeW e=(EdgeW) o;
            return Double.compare(this.getWeight(), e.getWeight());
        }
        return -2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EdgeW){
            EdgeW e=(EdgeW) obj;
            return this.v == e.v && this.w == e.w && this.weight == e.weight;
        }
        return false;
    }

    @Override
    public String toString() {

        return "["+this.w+"<->"+this.v+" weight:"+weight+"]";
    }


    public int other(int i) {
        if (i==v)
            return w;
        else
            return v;
    }
}
