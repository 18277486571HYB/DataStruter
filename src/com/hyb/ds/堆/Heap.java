package com.hyb.ds.堆;

public class Heap <T extends Comparable<T>>{

    private T[] items;
    private int n;

    public Heap(int cap){
        //因为T继承了Comparable,所以要new这个,而不是Object
//        this.items= (T[]) new Object[cap];
        this.items=(T[])new Comparable[cap+1];
        this.n=0;
    }
    //比较两个位置的大小
    public boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

    public void swap(int i,int j){
        T t=items[i];
        items[i]=items[j];
        items[j]=t;
    }

    //往堆里插入一个元素,从1开始
    public void insert(T t){
        items[++n]=t;
        swim(n);
    }

    //上浮调整堆
    public void swim(int k){

        while (k>1){
            //如果父节点比当前节点小
            if (less(k/2,k)){
                //交换节点
                swap(k/2,k);
                k=k/2;
            }else break;
            //将位置调整
        }
    }

    //删除堆最大的元素
    public T delMax(){
        T max=items[1];
        //最根节点为最大节点
        //交换最大节点和最后一个节点
        swap(1,n);
        //删除最大节点
        items[n]=null;
        //n--
        n--;
        //让根节点下沉
        sink(1);
        return max;
    }

    //让根节点下沉
    public void sink(int index){

        while ((2*index+1)<=n){
            int maxChild;
            if (less(2*index,2*index+1))
                maxChild=2*index+1;
            else
                maxChild=2*index;
            if (less(maxChild,index))
                break;
            swap(maxChild,index);
            index=maxChild;
        }
    }
    //根据范围下沉
    public void sink(int index,int range){

        while (2*index+1<=range){
            //判断当前节点中较大的子节点
            int max;
            if (less(2*index,2*index+1)){
                max=2*index+1;
            }else max=2*index;

            //将当前节点与最大子节点比较
            if (less(max,index)){
                break;
            }
            swap(index,max);
            index=max;
        }
    }

    //根据传过来的数组,生成堆
    public void ArrayHeap(T[] heap){
        //先将所有元素拷贝进堆里
        System.arraycopy(heap,0,items,1,heap.length);
        //然后要对元素进行下沉,这里是从长度的1/2开始,因为剩余的都是叶子节点
        for (int i=heap.length/2;i>0;i--){
            //下沉
            sink(i,heap.length-1);
        }
    }

    //堆排序
    public void heapSort(T[] heap){
        ArrayHeap(heap);
        //标记与根节点交换的最后一个节点位置
        int last=heap.length;
        while (last!=1){
            //交换头节点与尾结点
            swap(1,last);
            //让last改变
            last--;
            //让头节点下沉
            sink(1,last);

        }
        //将heap中的数据再复制过去
        System.arraycopy(items,1,heap,0,heap.length);
    }

    public static void main(String[] args) {
        Heap<String> stringHeap = new Heap<>(7);
//        stringHeap.insert("A");
//        stringHeap.insert("B");
//        stringHeap.insert("C");
//        stringHeap.insert("D");
//        stringHeap.insert("E");
//        stringHeap.insert("F");
//        stringHeap.insert("G");
//        String result=null;
//        while ((result=stringHeap.delMax())!=null){
//            System.out.println(result);
//        }
        String[] a=new String[]{"G","F","E","D","C","B","A"};
        stringHeap.heapSort(a);
        for (String s :
                a) {
            System.out.println(s);
        }
    }
}
