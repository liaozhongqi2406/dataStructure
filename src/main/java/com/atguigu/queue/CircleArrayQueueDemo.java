package com.atguigu.queue;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列的案例~~~");
        CircleArray queue = new CircleArray(4);
        String key = ""; //接受用户输入
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("show:显示队列");
            System.out.println("exit:退出程序");
            System.out.println("add:添加数据");
            System.out.println("get:从队列中取出数据");
            System.out.println("head:查看队列头的数据");
            key = sc.next();
            switch (key) {
                case "show":
                    queue.showQueue();
                    break;
                case "add":
                    System.out.println("请输入一个数字");
                    int value = sc.nextInt();
                    queue.addQueue(value);
                    break;
                case "get":
                    try {
                        System.out.println(queue.getQueue());
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "head" :
                    try {
                        System.out.println(queue.headQueue());
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "exit":
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出！");
    }
}
class CircleArray{
    private int maxSize; //数组的最大容量
    private int front = 0;
    private int rear = 0;
    private int[] arr; //存放数据

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
    }

    //判断队列是否已满
    public boolean isFull() {
        return (rear + 1)%maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if(isFull()) {
            System.out.println("队列已满，不能加入数据");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        rear = (rear + 1) %maxSize;
    }

    //获取队列的数据，出队列
    public int getQueue() {
        if(isEmpty()) {
            throw  new RuntimeException("队列空，不能取出数据");
        }
        int  value = arr[front];
        front = (front + 1) %maxSize;
        return value;
    }

    //显示队列中的所有数据
    public void showQueue() {
        if(isEmpty()) {
            System.out.println("队列空的，没有数据~~~");
            return;
        }
        for (int i = front; i < front+size(); i++) {
            System.out.println("arr[" +i%maxSize+"]="+arr[i%maxSize]);
        }
    }

    //获取当前数据的有效长度
    public  int size() {

        /*if(isEmpty()) {
            return 0;
        }
        int count = 0;
        int head = front;
        while(true) {
            count ++;
            head++;
            if((head+1) % maxSize == rear) {
                break;
            }
        }
        return count;*/

        return (rear + maxSize -front) % maxSize;
    }

    //显示队列的头元素
    public int headQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列是空的，没有数据~~~");
        }
        return arr[front];
    }

}