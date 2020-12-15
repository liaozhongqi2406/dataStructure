package com.sort;

import com.array.Array;

import java.util.Arrays;

/**
 * @author LiaoZQ
 * @version 1.0
 * @date 2020/9/9 21:12
 */
public class Sorts {

    //冒泡排序 a表示数组, n表示数组的大小
    public static void bubbleSort(int[] a, int n) {
        if( n <= 1 )return;
        for(int i = 0 ; i< n ;++i) {
            boolean flag = false;
            for (int j = 0; j < n - i -1 ; j++) {
                if(a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
               if(!flag) {
                   break;
               }
            }
        }
    }

    /*
        冒泡排序改进,在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界
        对于边界外的元素在下次循环中无需比较
    * */
    public static void bubbleSort2(int[] a ,int n) {
        if( n <= 1) return;
        int lastCompare  = 0;
        int sortBorder = n -1;
        for (int i = 0; i < n ; i++) {
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if(a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                    lastCompare = j;
                }
            }
            sortBorder = lastCompare;
            if( !flag) {
                break;
            }
        }
    }

    //插入排序
    public static void insertSort(int[] a, int n) {
      if(n <= 1) return;
      for (int i = 0; i <n ; i++) {
          int tmp = a[i];
          int j = i-1;
          for (; j >= 0 ; j--) {
             if(tmp < a[j]) {
                 a[j+1] = a[j];
             }else{
                 break;
              }
          }
          a[j+1] = tmp;
        }
    }


    //选择排序
    public static  void selectionSort(int[] a, int n) {
        if(n <= 1) return;
        for (int i = 0; i < n ; i++) {
            int min = i;
            for (int j = i+1; j <n ; j++) {
                if(a[j] < a[min]) {
                  min =  j;
                }
            }
            if(min != i) {
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }

    //归并排序
    public static void mergeSort(int[] a,int n) {
        mergeSortInternally(a,0,n-1);
    }

    //递归分组
    private static void mergeSortInternally(int[] a, int p, int r) {
        if(p >= r) return;
        int q = p + (r - p)/2;
        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);
        merge(a,p,q,r);
    }

    //合并排序
    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0; //初始化变量 i j k
        int[] tmp = new int[r-p+1]; //申请一个大小和a[p...r]一样的临时数组
        while(i <= q && j <= r) {
            if(a[i] <= a[j]){
                tmp[k++]=a[i++];
            }else {
                tmp[k++]=a[j++];
            }
        }
        int start = i;
        int end = q;
        if( j <= r) {
            start = j;
            end = r;
        }
        while(start <= end) {
            tmp[k++] = a[start++];
        }

        for ( i = 0; i <= r-p ; i++) {
            a[p+i] = tmp[i];
        }
    }

    /**
     * 合并(哨兵)
     *
     * @param arr
     * @param p
     * @param q
     * @param r
     */
    public static void mergeBySentry(int[] arr, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];
        for (int i = 0; i <= q-p ; i++) {
            leftArr[i] = arr[p+i];
        }
        //第一个数组添加哨兵（最大值）
        leftArr[q - p + 1] =Integer.MAX_VALUE;
        for (int i = 0; i < r -q ; i++) {
            rightArr[i] =arr[q+1+i];
        }
        rightArr[r-q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            }else {
                arr[k++] = rightArr[j++];
            }
        }
    }

    //快速排序
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a,0,n-1);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        if(p >= r) return;
        int q = partition(a,p,r);
        quickSortInternally(a,p,q-1);
        quickSortInternally(a,q+1,r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if(a[j] < pivot) {
                if(i == j) {
                    ++i;
                }else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j]=tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        return i;
    }


    /*
    *   桶排序
    *
    * */

    public static void bucketSort(int[] arr, int bucketSize){
        if(arr.length < 2){
            return;
        }
        //数组的最小值
        int minValue = arr[0];
        //数组的最大值
        int maxValue = arr[1];
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] < minValue) {
                minValue = arr[i];
            }else if(arr[i] >maxValue) {
                maxValue = arr[i];
            }
        }

        //桶数量
        int bucketCount = (maxValue - minValue) /bucketSize +1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArr = new int[bucketCount];

        //将数组中值分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (arr[i] - minValue) / bucketSize ;
            if(indexArr[bucketIndex] == buckets[bucketIndex].length){
                ensureCapcity(buckets,bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = arr[i];
        }
        //对于每个桶进行排序，这里使用了快速排序
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if(indexArr[i] == 0 )
                continue;
            quickSort(buckets[i],buckets[i].length);
            for (int j = 0; j < indexArr[i]; j++) {
                arr[k++] = buckets[i][j];
            }
        }
    }

    /*
    *   数组扩容
    *   两倍扩容
    * */
    private static void ensureCapcity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length *2];
        for (int i = 0; i < tempArr.length; i++) {
            newArr[i] = tempArr[i];
        }
        buckets[bucketIndex] = newArr;
    }


    /*
    * 计数排序
    * */
    public static void countingSort(int[] a, int n) {
        if( n <= 1 )return;
        //查找数组中数据的范围
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if(max < a[i]){
                max = a[i];
            }
        }
        //申请一个计数数组c,下标大小[0,max]
        int[] c = new int[max + 1];
        //计算每个元素的个数，放入c中
        for (int i = 0; i < n ; i++) {
            c[a[i]]++;
        }
        //依次累加
        for (int i = 1; i < max + 1; i++) {
            c[i] = c[i-1] + c[i];
        }
        //临时数组r,存储排序之后的结果
        int[] r = new int[n];
        //计数排序的关键步骤
        for (int i = n-1; i >= 0 ; i--) {
            int index = c[a[i]] -1;
            r[index] = a[i];
            c[a[i]]--;
        }
        //将结果拷贝给a数组
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }
    }

    /*
        基数排序
    * */
    public static  void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }

        //从个位开始，对数组arr按“指数”进行排序
        for (int exp = 1; max / exp > 0 ; exp *= 10) {
            countingSortForRadix(arr,exp);
        }

    }

    private static void countingSortForRadix(int[] arr, int exp) {
        if(arr.length <= 1) {
            return;
        }
        //计算每个元素的个数
        int[] c = new int[10];  //数字10位
        for (int i = 0; i < arr.length; i++) {
            c[(arr[i]/exp) % 10]++;
        }
        //计算排序后的位置
        for (int i = 1; i < c.length ; i++) {
            c[i] += c[i - 1];
        }
        //临时数组r，存储排序之后的结果
        int[] r = new int[arr.length];
        for (int i = arr.length - 1; i >= 0 ; i--) {
            r[c[(arr[i]/exp) % 10] -1] = arr[i];
            c[(arr[i]/exp) % 10]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r[i];
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,8,7};
        //bubbleSort2(array,array.length);
       // insertSort(array,array.length);
        //selectionSort(array,array.length);
        //mergeSort(array, array.length);
        //quickSort(array,array.length);
        int[] array2 = new int[]{1,23,322,21,321,22,32,123,432};
        //bucketSort(array,2);
        radixSort(array2);
        //System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }

}
