package com.stack;

/**
 * @author LiaoZQ
 * @version 1.0
 * @date 2020/9/9 17:20
 */
public class ArrayStack {
    private  String[] items;    //数组
    private  int count;     //栈中的元素个数
    private int n;          //栈的大小

    //初始化数组,申请一个大小为n的数组空间

    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    //入栈操作
    public boolean push(String item) {

        if(count == n ) return false;

        items[count] =item;

        count++;

        return true;
    }
    //出栈操作
    public String pop() {
        if(count == 0) return null;
        String tmp = items[count-1];
        --count;
        return tmp;

    }
}
