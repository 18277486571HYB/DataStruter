package com.hyb.ds.递归;

public class Labyrinth {

    public static void main(String[] args) {
        Labyrinth labyrinth = new Labyrinth();
//        labyrinth.test(5);
        int[][] map=new int[8][9];
        //第一行,最后一行,最左和最右边都为1,表示有墙壁
        for (int i = 0; i < 9; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][8]=1;
        }
        //然后随便在迷宫里面造一些围墙
        map[3][2]=1;
        map[2][2]=1;
        map[3][3]=1;
        map[3][4]=1;
        map[4][7]=1;
        map[3][7]=1;
        map[5][7]=1;
        map[6][5]=1;
        map[7][4]=1;
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 9; i1++) {
                System.out.print(map[i][i1]+" ");
            }
            System.out.println();
        }

        //指定从1,1开始,7,8结束
        labyrinth.findRoad(map,1,1);

        System.out.println("==================");
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 9; i1++) {
                System.out.print(map[i][i1]+" ");
            }
            System.out.println();
        }
    }

    private void findRoad(int[][] map, int i, int j) {
        //到底终点
        if (i==6&&j==7){
            map[i][j]=2;
            return ;
        }
        if (map[i][j]==0 ){
            map[i][j]=2;
            if (map[i+1][j]==0){
                findRoad(map,i+1,j);
            }else if (map[i][j+1]==0){
                findRoad(map,i,j+1);
            }else if (map[i-1][j]==0){
                findRoad(map,i-1,j);
            }else if (map[i][j-1]==0){
                findRoad(map,i,j-1);
            }
        }
    }


    public void test(int m){
        if (m>1)
            test(m-1);
        System.out.println(m);
    }
}
