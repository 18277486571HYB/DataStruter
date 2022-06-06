package com.hyb.ds.排序.选择排序;

import java.util.Arrays;
import java.util.Collections;

public class SelectSort {

    public int[] selectSort(int[] sort){

        for (int i=1;i<=sort.length-1;i++){
            //假定p1就是最小的
            int p1=sort[i-1];
            int index=-1;
            for (int j=i+1;j<=sort.length-1;j++){
                int p3=sort[j-1];
                //如果后面有值比p1小
                if (p3<p1){
                    //让p1重新复制
                   p1=p3;
                   //拿到最小值的下标
                   index=j-1;
                }
            }
            //交换
            //index=-1代表后面没有比p1还小的值,那就是p1就是最小值
            if (index!=-1){
                //先让后面最小值的位置填入当前位置
                sort[index]=sort[i-1];
                //然后让当前位置填入后面的最小值
                sort[i-1]=p1;
            }

        }
        return sort;

    }
}

class Test{
    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] p=new int[]{22,-1,3,32,12,90};
        int[] ints = selectSort.selectSort(p);
        System.out.println(Arrays.toString(ints));

    }
}
