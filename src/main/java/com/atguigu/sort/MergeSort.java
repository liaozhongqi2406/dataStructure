package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] {8,9,1,7,2,3,5,4,6,0};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));


//        int[] arr = new int[8000000];
//        for (int i = 0; i < 8000000 ; i++) {
//            arr[i] = (int)(Math.random()*8000000);
//        }
//        System.out.println("排序前");
//        Date data1 = new Date();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String data1str = format.format(data1);
//        System.out.println("排序前的时间为:" + data1str);
//
//
//
//        Date date2 = new Date();
//        String date2Str = format.format(date2);
//        System.out.println("排序后的时间："+date2Str);
    }

    public static void mergeSort(int[] arr,int left, int right, int[] temp) {
         if(left < right) {
             int mid = (left + right) / 2;
             mergeSort(arr,left,mid,temp);
             mergeSort(arr,mid+1,right,temp);
             merger(arr,left,mid,right,temp);
         }
    }

    public static void merger(int[] arr, int left, int mid, int right, int[] temp) {
        int i  = left;
        int j = mid +1;
        int t = 0; //指向temp数组的索引
        while ( i <=mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //将还有剩余的一边数据全部填充到temp
        while( i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
   }


}
