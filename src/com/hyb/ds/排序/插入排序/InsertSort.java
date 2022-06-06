package com.hyb.ds.排序.插入排序;

public class InsertSort {

    public int[] insertSort(int [] sort){

        for (int i = 1; i <= sort.length-1; i++) {
            int n=i;
            while (true){

                int f=sort[n-1];
                int e=sort[n];
                if (f>e){
                    sort[n]=f;
                    sort[n-1]=e;
                }else if (f<e)
                    break;
                n--;
                if (n==0)
                    break;


            }

        }
        return sort;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] ints = insertSort.insertSort(new int[]{123, 650, 15555, 34, 890, 4003});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}
