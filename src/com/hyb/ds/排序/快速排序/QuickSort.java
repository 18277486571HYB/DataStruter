package com.hyb.ds.排序.快速排序;

public class QuickSort {

    public void quickSort(int[] a,int leftIndex,int rightIndex){
//        if (rightIndex==0 || leftIndex==9){
//            return;
//        }
        int i=leftIndex;
        int j=rightIndex;
        int key=a[i];
        while (leftIndex<rightIndex){

            while ((leftIndex<rightIndex)&&a[leftIndex]<key){
                leftIndex++;
            }

            while ((leftIndex<rightIndex)&&a[rightIndex]>key){
                rightIndex--;
            }
            if ((a[leftIndex]==a[rightIndex])&&(leftIndex<rightIndex)) {
                leftIndex++;
            }else{
                int t=a[leftIndex];
                a[leftIndex]=a[rightIndex];
                a[rightIndex]=t;
            }
        }
//        if (leftIndex==rightIndex){
//            a[i]=a[leftIndex];
//            a[leftIndex]=key;
//        }
        if (leftIndex-1>i)
            quickSort(a,i,leftIndex-1);
        if (rightIndex+1<j)
            quickSort(a,rightIndex+1,j);


    }




    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int [] ints=new int[]{6, 6, 2, 7, 9, 3, 4, 5, 10, 6,8};
        quickSort.quickSort(ints,  0, 10);
        for (int s :
                ints) {
            System.out.println(s);
        }

    }
}
