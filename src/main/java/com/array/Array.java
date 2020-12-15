package com.array;

/**
 *  1) 数组的插入，删除。按照下标随机访问操作
 *  2）数组中的数据是int类型的
 *
 * @author LiaoZQ
 * @version 1.0
 * @date 2020/7/30 9:33
 */



public class Array {
    //定义整形数据data保存数据
    public int data[];
    //定义数组长度
    public int n;
    //定义数组中的实际个数
    public int count;

    //构造方法,定义数组的大小
    public Array(int capacity) {
            this.data = new int[capacity];
            this.n = capacity;
            this.count = 0;
    }

    //根据索引,找到数组中元素并返回
    public int find(int index) {
        if(index < 0 || index <= count) return -1;
        return data[index];
    }

    //插入元素
    public boolean insert(int index , int value) {
        if(count == n) {
            System.out.println("数组已满,没有可以插入的位置");
            return  false;
        }
        //数组没满,可以插入到数组中
        if(index < 0 || index > count) {
            System.out.println("插入位置不合法");
            return false;
        }

        for(int i = count; i > index; --i) {

            data[i] = data[i-1];

        }
        data[index] = value;
        ++count;
        return true;
    }

    //根据索引删除数组中的元素
    public boolean delete(int index) {
        if(index < 0 || index >= count) return false;

        for (int i = index+1; i<count;++i) {
             data[i-1] = data[i];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.insert(3, 11);
        array.printAll();

    }
}
