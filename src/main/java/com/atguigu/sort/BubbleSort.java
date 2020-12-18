package com.atguigu.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,4,2,5,3,6,1,3,6,8};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        
    }

    public static void bubbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i -1  ; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag) {  //没有发生交换，代表整体已经有序
                return;
            }else {
                flag = false;
            }
        }
    }

}
