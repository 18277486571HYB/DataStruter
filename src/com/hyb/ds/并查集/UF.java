package com.hyb.ds.并查集;

public class UF {
    private int[] items;
    private int[] highs;
    private int count;

    public UF(int n){
        this.count=n;
        items=new int[n];
        highs=new int[n];
        //规定初始化的时候索引下标即每个位置的值
        //这个值代表所在分组
        //也就是说初始化的时候n就代表分组个数
        //初始化的时候每个节点都是高度为1
        for (int i = 0; i < n; i++) {
            items[i]=i;
            highs[i]=1;
        }


    }
    public int getCount(){
        return count;
    }

    //元素所在分组根标识
    public int getRootGroup(int p){
        while (p != items[p]) {
            p = items[p];
        }
        return p;
    }

    //判断两个点是否在同一分组中
    public boolean connected(int p,int q){
        return getRootGroup(p)==getRootGroup(q);
    }

    public void unioned(int p,int q){
        int pgroup = getRootGroup(p);
        int qgroup= getRootGroup(q);
        if (pgroup==qgroup){
            return;
        }
        //如果p的高度比q的高度低
        //那么就要高的作为根节点
        if (highs[pgroup]<highs[qgroup]){
            items[pgroup]=qgroup;
        }else
            items[qgroup]=pgroup;

        count--;
    }
}
class Test{
    public static void main(String[] args) {
        UF uf = new UF(20);
        System.out.println("分组前:"+uf.getCount());
        uf.unioned(0,1);
        uf.unioned(6,9);
        uf.unioned(3,8);
        uf.unioned(5,11);
        uf.unioned(2,12);
        uf.unioned(6,10);
        uf.unioned(4,8);
        System.out.println("分组后:"+uf.getCount());
    }
}
