package com.hyb.ds.排序.归并排序;

public class MergeSort {

    public static void mergeSort(int left,int right,int[] a,int[] b){

        if (left<right){
            //不能直接用长度计算mid,这要根据每个分组情况计算mid
            int mid=(left+right)/2;
            //左边递归
            mergeSort(left,mid,a,b);
            //右边递归
            mergeSort(mid+1,right,a,b);
            //合并
            merge(left,right,mid,a,b);
        }


    }

    private static void merge(int left,int right,int mid, int[] a,int [] b) {
        int i=left;
        int j=mid+1;
        int t=0;

        //只能循环左右两边,不能越过mid,或者越过right
        while (i<=mid && j<=right){
            if (a[i]<=a[j]){
                b[t]=a[i];
                i++;
                t++;
            }else{
                b[t]=a[j];
                j++;
                t++;
            }

        }


        //如果循环完毕,i不等于mid,j不等于right
        //说明两边都有剩余,直接将剩余的转移到b数组中
        while (i<=mid){
            b[t]=a[i];
            i++;
            t++;
        }
        while (j<=right){
            b[t]=a[j];;
            j++;
            t++;
        }

        //这一步和关键,要将新数组的值复制到原数组中
        //这里有人可能会问,能否直接返回新数组?
        //不行,因为这里是递归,有可能新数组针对的是旧数组某些分组进行排序,如果直接返回,就代替了原数组
        //所以这里只能一一复制,没有别的选择
        // 初始化新数组下标
        t=0;
        //初始化left,因为这个left是不能改变,切记一定要用给一个变量去接,因为在循环中可能被改变
        int bleft=left;
        while (bleft<=right){
            a[bleft]=b[t];
            t++;
            bleft++;
        }
    }


    public static void main(String[] args) {
        int[] a=new int[]{9,3,10,5,89,0,4};
        int[] b=new int[a.length];
        MergeSort.mergeSort(0,a.length-1,a,b);
        for (int i :
                a) {
            System.out.println(i);
        }
    }
}
