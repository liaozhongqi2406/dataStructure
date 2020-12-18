package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = new int[] {1,2,4,2,5,3,6,1,3,6,8};
//        insertSort(arr);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }

        int[] arr = new int[800000];
        for (int i = 0; i < 800000 ; i++) {
            arr[i] = (int)(Math.random()*800000);
        }
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1str = format.format(data1);
        System.out.println("排序前的时间为:" + data1str);

        insertSort(arr);

        Date date2 = new Date();
        String date2Str = format.format(date2);
        System.out.println("排序后的时间："+date2Str);


    }

    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            //定义带插入的坐标
            insertIndex = i -1;
            while(insertIndex >= 0 && arr[insertIndex] > insertVal) {
//                arr[insertIndex] = arr[insertIndex+1];
                arr[insertIndex+1] =arr[insertIndex];
                insertIndex--;
            }

            if(insertIndex+1 != i) {
                arr[insertIndex+1] = insertVal;
            }
        }
    }
}
