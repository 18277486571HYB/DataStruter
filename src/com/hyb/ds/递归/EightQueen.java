package com.hyb.ds.递归;

import java.util.Arrays;

public class EightQueen {

    //定义存储的一维数组
    private  int[] map=null;

    private final int size;

    private int count;


    public EightQueen(int size) {
        this.map = new int[size];
        this.size = size;
    }

    public int count(){
        return count;
    }

    //注意,这里是传入的是行,0代表从第0行开始
    public void nextRow(int row){

        //如果当前行到了8,说明放完了
        if (row==size){
            count++;
            print();
            return;
        }

        //循环当前行的列
        for(int i = 0; i < size; i++) {
            //先放置在该位置
            map[row]=i;
            //判断该位置是否合理
            //如果check返回true,说明放置的位置合理,直接下一行
            //如果check返回false,说明该位置和其他皇后冲突了,会继续执行当前这个for循环,
            //也就是给当前行的下一列继续放置,继续判断.
            if (check(row)){
                nextRow(row+1);
            }
        }

    }

    private void print() {
        for (int i :
                map) {
            System.out.print(i);
        }
        System.out.println();

    }

    private boolean check(int n){

        //注意,这里是通过行去循环的,不是map的长度,map长度一开始就固定了
        //因为一行存一个皇后,所以这里循环实际上就是循环map数组里的实际皇后数量
        //为什么要用实际皇后的数量去循环?
        //因为你本身要判断的就是和其他皇后是否冲突,那不用实际皇后的数量去循环用什么?
        ///如果你用size作为循环,相当于每次进来都要判断一下.
        //比如,你放的第一个皇后,这个时候肯定是没有冲突的,但是因为你用size循环,所以此刻一定会进入
        //进入后,肯定会判断map[i]==map[n],
        //放的第一个皇后时,是在第0行,所以n=0,那么当i=0,这个判断就会成立,就会返回false
        //返回false就说明我们有冲突,直接进行下一列放置,但我们本身就没有冲突的,
        //这样就会导致我们的每一列都放了一个皇后.
        for (int i = 0; i < n; i++) {
            /*
            * i==n,因为我们传入的是当前行,
            * 所以判断数组下标(代表行)是否有相等就说明是否存在相同行的皇后
            * 但是没必要判断,因为不可能在同一行
            * map[i]=map[n],既然下标代表行,说明map[i]代表列,如果存在列相同,也不能放
            * 最后的Math.abs方法是取绝对值
            * 至于Math.abs(n-i)==Math.abs(map[n]-map[i])是判断斜率是否为1
            * 根据我们前面的分析,(y2-y1)/(x2-x1)=1,所以y2-y1=x2-x1
            * 所以map[n]-map[i]=n-i,因为可能出现负数,所以加上绝对值
            * */
            if (map[i]==map[n] || Math.abs(n-i)==Math.abs(map[n]-map[i])){
                return false;
            }
        }
        return true;
    }
    
}

class Test{
    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen(8);
        eightQueen.nextRow(0);
        System.out.println("一共有多少种解法:"+ eightQueen.count());
    }
}
