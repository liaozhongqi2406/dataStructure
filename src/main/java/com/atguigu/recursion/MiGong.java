package com.atguigu.recursion;

public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组来模拟迷宫
        int[][] map = new int[8][7];
        //使用1来表示墙
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for (int i = 0; i < 8 ; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板  1 表示
        map[3][1] = 1;
        map[3][2] = 1;
       /* map[1][2] = 1;
        map[2][2] = 1;*/
        //输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < 7 ; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        Boolean  flag = setWay(map, 1, 1);
        System.out.println(flag);

        System.out.println("走过之后地图的情况");
        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < 7 ; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    //使用递归回溯来确定小球的路
    // 1 map 地图   ij表示小球从地图的那个位置开始出发
    // 当小球能走到map[6][5]位置，说明通路已经找到
    private static Boolean setWay(int[][] map, int i, int j) {
        if(map[6][5] == 2) {
            return true;
        }else {
            if(map[i][j] == 0) { //当前这个点还没有走过
                map[i][j] = 2;   //假定该点是可以走通的
                //策略 下 -> 右 -> 上 -> 左
                if(setWay(map,i+1,j)){
                    return true;
                }else if(setWay(map,i,j+1)){
                    return true;
                }else if(setWay(map,i-1,j)){
                    return true;
                }else if(setWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j] = 3;  //此路不通
                    return false;
                }
            }else {
                return false;
            }
        }
    }

}
