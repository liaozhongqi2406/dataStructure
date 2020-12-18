package com.atguigu.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,4,2,5,3,6,1,3,6,8};
        selectSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void selectSort(int[] arr) {

        int tmp;
        int min = 0;
        for (int i = 0; i < arr.length ; i++) {
            min = i;
            for (int j = i +1 ; j < arr.length; j++) {
                if(arr[min]  > arr[j]) {
                    min = j;
                }
            }
            tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
    }
}
