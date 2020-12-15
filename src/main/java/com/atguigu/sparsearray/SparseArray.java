package com.atguigu.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组。。。。。。。。。。。");
        for (int[] ints : chessArr) {
            for (int data : ints) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        //将二维数组砖为稀疏数组的思想
        int sum = 0;
        // 1.先遍历二维数组，得到非0数据的个数
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11 ; j++) {
                if(chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2. 创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        //3. 给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0; //用于记录是第几个非0的数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11 ; j++) {
                if(chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        System.out.println("得到的稀疏数组为");
        //4. 将创建好的稀疏数组打印出来
        for (int i = 0; i < sparseArr.length ; i++) {
            System.out.println(sparseArr[i][0] + " " + sparseArr[i][1] + " " + sparseArr[i][2]);
        }
        System.out.println("---------------------");

        //5. 根据稀疏数组将二维数组进行还原
        int chessMap2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessMap2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("还原后的数组为");
        for (int[] ints : chessMap2) {
            for (int data : ints) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }



     }
}
