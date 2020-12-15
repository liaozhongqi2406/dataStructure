package com.queue;

/**
 * @author LiaoZQ
 * @version 1.0
 * @date 2020/9/9 19:45
 */
public class ArrayQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    //申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item) {
        // 如果tail == n 表示队列已满
        if(tail == n) return false;
        items[tail] =item;
        ++tail;
        return true;
    }
    //优化入队操作
    public boolean enqueue2(String item) {
        if(tail == n) {
            //整个队列已经被占满,返回false
            if(head == 0) return false;
            for (int i = head; i < tail ; i++) {
                items[i-head] =items[i];
            }
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        ++tail;
        return true;
    }


    //出队
    public String dequeue() {
        if(head == tail) return null;
        String ret = items[head];
        ++head;
        return ret;
    }

}
