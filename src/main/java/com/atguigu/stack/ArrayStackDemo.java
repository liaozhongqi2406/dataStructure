package com.atguigu.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //创建一个ArrayStack
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        while(loop) {
            System.out.println("show:显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示添加元素入栈");
            System.out.println("pop:表示元素出栈");
            key = sc.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "exit":
                    sc.close();
                   loop = false;
                    break;
                case "push":
                    System.out.println("请输入一个数字:");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.println(res+" ");
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }
}

//创建一个ArrayStack栈
class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;   //栈顶初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }
    //栈空
    public boolean isEmpty() {
        return top == -1;
    }
    //入栈
    public void push(int value) {
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }
    //出栈
    public int pop () {
        if(isEmpty()) {
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = stack[top];
        top --;
        return value;
    }
    //显示栈的情况
    public  void list() {
        if(isEmpty()) {
            System.out.println("栈空，没有数据。。。");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.println(i +" "+stack[i]);
        }
    }
}

