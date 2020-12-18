package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
//      int[] arr = new int[] {8,9,1,7,2,3,5,4,6,0};
//
//        shellSort2(arr);
//        System.out.println("原始数据=" + Arrays.toString(arr));
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000 ; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1str = format.format(data1);
        System.out.println("排序前的时间为:" + data1str);

        //insertSort(arr);
        //shellSort(arr);
        shellSort2(arr);

        Date date2 = new Date();
        String date2Str = format.format(date2);
        System.out.println("排序后的时间："+date2Str);


    }

    private static void shellSort2(int[] arr) {
        int temp = 0;
        for(int gap = arr.length/2 ;gap >=1 ;gap /= 2) {
            for (int i = gap; i <  arr.length; i++) {
                int j = i;
                temp = arr[j];
                if(arr[j] < arr[j-gap]) {
                    while (j-gap >= 0 && temp < arr[j-gap]) {
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //退出while时就找到了插入的位置
                    arr[j] = temp;
                }
            }
        }
    }

    private static void shellSort(int[] arr) {
        int temp = 0;
     //   int count = 0;

        for(int gap = arr.length/2 ; gap >= 1 ;gap /= 2) {
            for (int i = gap; i <  arr.length; i++) {
                for (int j = i -gap; j >= 0 ; j -= gap) {
                    if(arr[j] > arr[j+gap]) {
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }

       // System.out.println("排序后的数组" + Arrays.toString(arr));
        /*for (int i = 5; i <  arr.length; i++) {
            for (int j = i -5; j >= 0 ; j -= 5) {
                if(arr[j] > arr[j+5]) {
                    temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
            }
        }
        System.out.println("希尔排序第一轮后=" + Arrays.toString(arr));
        for (int i = 2; i <  arr.length; i++) {
            for (int j = i -2; j >= 0 ; j -= 2) {
                if(arr[j] > arr[j+2]) {
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println("希尔排序第二轮后=" + Arrays.toString(arr));
        for (int i = 1; i <  arr.length; i++) {
            for (int j = i -1; j >= 0 ; j -= 1) {
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("希尔排序第三轮后=" + Arrays.toString(arr));*/
    }


}
