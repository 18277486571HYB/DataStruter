package com.hyb.ds.排序.桶排序基数排序;

public class BucketSort {

    public static void bucketSort(int [] a){

        //10为桶数量,a.length代表每个桶存放的最多数量
        int[][] bucket=new int[10][a.length];
        //求出最大值
        int max = maxValue(a);
        //计算最大值位数
        int count = count(max);

        int mod=1;

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < a.length; j++) {
                int k=(a[j]/mod)%10;
                //从1开始放
                int index=++bucket[k][0];
                bucket[k][index]=a[j];

            }
            //取出元素放到原数组中
            int index=0;
            for (int m=0;m<10;m++){
                if (bucket[m][0]!=0){
                    for (int n=1;n<=bucket[m][0];n++){
                        a[index]=bucket[m][n];
                        index++;
                    }
                    bucket[m][0]=0;
                }
            }


            mod=mod*10;
        }
    }

    private static int count(int value){
        int v=value;
        int count=0;
        while (v!=0){
            v=v/10;
            count++;
        }
        return count;
    }

    private static int maxValue(int[]a){

        int max=a[0];
        for (int i = 1; i < a.length; i++) {
            if (max< a[i]){
                max=a[i];
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[] a=new int[]{10,18,9,923,69842,90,1781978};
        long l = System.currentTimeMillis();
        System.out.println(l);
        BucketSort.bucketSort(a);
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
