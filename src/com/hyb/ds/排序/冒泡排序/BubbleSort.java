package com.hyb.ds.排序.冒泡排序;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort<E> {

    public List<E> BubbleMaxSort(List<E> sort){

        int length = sort.size();
        //代码优化,如果当前冒泡这一轮一次都没有发生过冒泡,说明已经是顺序的了,后面用再排序了.
        boolean f=false;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length-i-1; j++) {
                E o1 = sort.get(j);
                E o2 = sort.get(j+1);
                if (o1 instanceof Integer && o2 instanceof Integer){
                    if (((Integer) o1).compareTo((Integer) o2) > 0){
                        f=true;
                        sort.set(j+1, o1);
                        sort.set(j,o2);
                    }
                }
            }
            if (!f){
                break;
            }
            f=false;
        }
        return sort;

    }


}

class Test{
    public static void main(String[] args) {
        BubbleSort<Integer> integerBubbleSort = new BubbleSort<>();
        /*
        * Arrays.asList(11, 2, -1, 33, 4, 55, 6) 返回的是
        * java.util.Arrays的静态内部类,
        * 并不是import java.util.List里的ArrayList
        * 所以要利用import java.util.List里的ArrayList进行初始化
        * */
        List<Integer> integers = integerBubbleSort.BubbleMaxSort(new ArrayList<>(Arrays.asList(11, 2, -1, 33, 4, 55, 6)));
        integers.forEach(System.out::println);

    }
}
