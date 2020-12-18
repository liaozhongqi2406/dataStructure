package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QucikSort {
    public static void main(String[] args) {
//        int[] arr = new int[] {8,9,1,7,2,3,5,4,6,0};
//        quickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));


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
        quickSort(arr,0,arr.length-1);

        Date date2 = new Date();
        String date2Str = format.format(date2);
        System.out.println("排序后的时间："+date2Str);
    }

    private static void quickSort(int[] arr,int p,int r) {

        if(p>=r) return;
        int q = partition(arr,p,r);
        quickSort(arr,p,q-1);
        quickSort(arr,q+1,r);

    }


    //这里是对最后一个值进行排序
    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r ; j++) { //i指向左边第一个大于等于arr[r]的数
            if(arr[j] <pivot) {
                if(i==j) {
                    ++i;
                }else {
                    int temp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] =temp;
        return i;
    }



}
