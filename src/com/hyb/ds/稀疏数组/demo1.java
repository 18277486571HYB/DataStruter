package com.hyb.ds.稀疏数组;

public class demo1 {
    public static void main(String[] args) {
        // 创建一个11x11的二维数组,存放值22,15,56,7 其余都为0
        int[][] arr = new int[11][11];
        arr[2][2] = 22;
        arr[5][5] = 15;
        arr[6][6] = 56;
        arr[7][7] = 7;
        //创建一个长度为5的一维Object数组
        Object[] sparseArr = new Object[5];
        demo2 demo2 = new demo2(11, 11, 4);
        sparseArr[0]=demo2;
        // 遍历数组arr
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
               if (arr[i][j] != 0) {
                   count++;
                   sparseArr[count]=new demo2(i, j, arr[i][j]);
               }
            }
        }
        //遍历sparseArr数组
        for (Object o : sparseArr) {
            //如果sparseArr[i]不为null
            if (o != null) {
                //输出sparseArr[i]
                System.out.println(o);
            }
        }

    }

}

class demo2{
    private int row;
    private int col;
    private int value;

    public demo2(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "demo2{" +
                "row=" + row +
                ", col=" + col +
                ", value=" + value +
                '}';
    }
}