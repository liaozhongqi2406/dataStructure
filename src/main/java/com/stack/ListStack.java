package com.stack;

/**
 * @author LiaoZQ
 * @version 1.0
 * @date 2020/9/9 19:27
 * 基于链表实现的栈
 */
public class ListStack {
    private Node top = null;

   public void push(int value) {
       Node newNode = new Node(value,null);
       if(top == null) {
           top = newNode;
       }else{
           newNode.next = top;
          top = newNode;
       }
   }

   public int pop() {
       if(top == null) return -1;
       int value = top.data;
       top = top.next;
       return value;
   }

    public void printAll() {

       Node p = top;
       while ( p != null) {
           System.out.println(p.data);
           p = p.next;
       }
    }


    private static class Node{
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
