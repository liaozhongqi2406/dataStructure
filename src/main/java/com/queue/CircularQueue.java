package com.queue;

/**
 * @author LiaoZQ
 * @version 1.0
 * @date 2020/9/9 20:39
 */
public class CircularQueue {
    private String[] items;
    private int n = 0;

    private int head = 0;
    private int tail = 0;

    //初始化队列
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item) {
        if((tail +1) % n == head) return false;     //队列已满
        items[tail] =item;
        tail = (tail + 1) % n ;
        return true;
    }
    //出队

    public String dequeue() {
        if(head == tail) return  null;  //队列为空
        String ret = items[head];
        head = (head +1) % n;
        return ret;
    }

}
