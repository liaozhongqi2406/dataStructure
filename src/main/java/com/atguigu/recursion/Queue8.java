package com.atguigu.recursion;

/*
* 八皇后问题介绍
八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。
* 该问题是国际西洋棋棋手马克斯·贝瑟尔于1848年提出：在8×8格的国际象棋上摆放八个皇后，
* 使其不能互相攻击，即：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法
* */

/*
* 八皇后问题算法思路分析

第一个皇后先放第一行第一列
第二个皇后放在第二行第一列、然后判断是否OK， 如果不OK，继续放在第二列、第三列、依次把所有列都放完，找到一个合适
继续第三个皇后，还是第一列、第二列……直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解
当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到.
然后回头继续第一个皇后放第二列，后面继续循环执行 1,2,3,4的步骤 【示意图】

说明：理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，
* 用一个一维数组即可解决问题. arr[8] = {0 , 4, 7, 5, 2, 6, 1, 3} //对应arr 下标
* 表示第几行，即第几个皇后，arr[i] = val , val 表示第i+1个皇后，放在第i+1行的第val+1列
* */
public class Queue8 {

    int max = 8;
    int[] map = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("总计打印的次数"+count);
    }

    //算出有多少种摆放的位置
    private void check(int n) {
        if( n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            //都从0 开始试验
            map[n] = i;
            if(judge(n)) {
                check(n+1);
            }
        }
    }

    //判断摆放的皇后是否和前面已经摆放的皇后冲突
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //判断是否处在同一列或者是处在同一斜线
            if(map[i] == map[n] || Math.abs(n-i) ==Math.abs(map[n] -map[i])) {
                return false;
            }
        }
        return true;
    }
    //添加一个打印的方法
    private void print(){
        count++;
        for (int i = 0; i < max ; i++) {
            System.out.print(map[i] + " ");
        }
        System.out.println();
    }
}
