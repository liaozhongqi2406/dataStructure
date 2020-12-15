package com.search;

public class BSearchList {
    /*
    * 二分查找非递归实现
    * */
    public static  int bSearch(int[] a, int value) {
        int low = 0;
        int high = a.length -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(a[mid] == value) {
                return mid;
            }else if(a[mid] < value) {
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }
        return  -1;
    }

    /*
    * 二分查找的递归实现
    * */
    public static  int bSearch2(int[] a,int n, int value) {
        return bsearchInternally(a,0,n-1,value);
    }
    private static int bsearchInternally(int[] a, int low, int high, int value) {
        if( low > high) return -1;
        int mid = low + (high - low)/2;
        if(a[mid] == value){
            return  mid;
        }else if(a[mid] < value) {
           return bsearchInternally(a,mid +1,high,value);
        }else {
           return bsearchInternally(a,low,mid-1,value);
        }
    }

    /*
    * 二分查找中有重复的值，查找第一个等与value的值的位置
    * */
    public static  int bSearch3(int[] a,int n, int value) {
        int low =0;
        int high = n - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(a[mid] < value) {
                low = mid +1;
            }else if(a[mid] > value) {
                high = mid -1;
            }else {
                //当前面的没值或前面的值小于value时可以判定符合条件，其余的都算比value大处理
                if(mid == 0 || a[mid-1] < value) return mid;
                high = mid -1;
            }
        }
        return -1;
    }

    /*
     * 二分查找中有重复的值，查找最后一个等与value的值的位置
     * */
    public static  int bSearch4(int[] a,int n, int value) {
        int low =0;
        int high = n - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(a[mid] < value) {
                low = mid +1;
            }else if(a[mid] > value) {
                high = mid -1;
            }else {
                //当后面的没值或后面的值大于value时可以判定符合条件，其余的都算比value小处理
                if(mid == n-1 || a[mid+1] > value) return mid;
                low = mid + 1;
            }
        }
        return -1;
    }

    /*
    * 查找第一个大于等于给定值的元素
    * */
    public static  int bSearch5(int[] a,int n, int value) {
        int low =0;
        int high = n - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(a[mid] >= value) {
                if(mid == 0 || a[mid-1] < value) return mid;
                high = mid -1;
            }else {
                low = mid +1;
            }
        }
        return -1;
    }

    /*
     * 查找第一个小于等于给定值的元素
     * */
    public static  int bSearch6(int[] a,int n, int value) {
        int low =0;
        int high = n - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(a[mid] <= value) {
                if(mid == n-1 || a[mid+1] > value) return mid;
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,3,3,7,9,21,32,43};
        //int result = bSearch(arr, 3);
        //int result = bSearch3(arr,arr.length,3);
        //int result = bSearch4(arr,arr.length,3);
        int result = bSearch6(arr,arr.length,6);
        System.out.println(result);

    }
}
