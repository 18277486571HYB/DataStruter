package com.hyb.ds.查找.折半查找;

public class FoldSearch {

    public static int foldSearch(int value,int[] a){

        int left=0,right=a.length-1;

        if (value<a[0] || value>a[right])
            return -1;
        int middle;
        while (true){
//            middle=(left+right)/2;
            middle=(left+right)/((value-a[left])/(a[right]-a[left]));
            if (a[middle]<value){
                left=middle+1;
            }else if (a[middle]>value)
                right=middle-1;
            if (a[middle]==value)
                return middle;
            if (left==right)
                return -1;
        }

    }



    public static void main(String[] args) {
        int[] a=new int[]{1,3,5,7,8,9,10,15};
        System.out.println(FoldSearch.foldSearch(11, a));
    }
}
