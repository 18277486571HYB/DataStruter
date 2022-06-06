package com.hyb.ds.排序.希尔排序;

import com.hyb.ds.排序.插入排序.InsertSort;

public class ShellSort {

    public int[] shellSort(int[] a){
        int n=a.length;
        do {
            n = n / 2;
            if (n==1){
                InsertSort insertSort = new InsertSort();
                a=insertSort.insertSort(a);
            }
            for (int i = 0; i < n; i++) {
                if (a[i] > a[i + n]) {
                    int t = a[i + n];
                    a[i + n] = a[i];
                    a[i] = t;
                }
            }
        } while (n != 1);
        return a;
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] ints = shellSort.shellSort(new int[]{9, 6,8,9,45,78,23, 7, 4, 3, 1});
        for (int i :
                ints) {
            System.out.println(i);
        }
    }
}
