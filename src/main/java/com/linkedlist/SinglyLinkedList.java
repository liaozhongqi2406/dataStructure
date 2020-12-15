package com.linkedlist;

import java.util.Scanner;

/**
 * 1) 单链表的插入，删除，查找操作
 * 2）
 * @author LiaoZQ
 * @version 1.0
 * @date 2020/8/15 17:30
 */
public class SinglyLinkedList {

    private Node head = null;


    public Node findByValue(int value) {
        Node p = head;
        while(p !=null && p.data !=value)
            p = p.next;
        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while(p != null && pos != index) {
            p = p.next;
            ++pos;
        }
        return p;
    }

    //无头结点的插入
    //表头部结点插入
    public void insertToHead(int value){
        Node newNode = new Node(value,null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode){
        if(head== null) {
            head = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
    }

    //顺序插入，链表尾部插入
    public void insertTail(int value) {

        Node newNode = new Node(value,null);
        //空链表，可以将插入加点作为头结点
        if(head == null) {
            head = newNode;
        }else {
            Node p = head;
            while(p.next != null) {
               p = p.next;
            }
            p.next = newNode;
        }
    }

    //链表指定结点后面插入
    public void insertAfter(Node p,int value) {
        Node newNode = new Node(value,null);
        insertAfter(p,newNode);

    }

    public void insertAfter(Node p,Node newNode) {
        if(p == null) return;
        newNode.next = p.next;
        p.next = newNode;
    }

    //链表指定结点前面插入
    public void insertBefore(Node p,int value) {
        Node newNode = new Node(value,null);
        insertBefore(p,newNode);

    }

    public void insertBefore(Node p,Node newNode) {
        if(p == null) return;

        if( p == head) {
            newNode.next = p;
            head = newNode;
        }else {
            Node q = head;
            while( q != null && q.next != p){
                q = q.next;
            }
            if(q == null) return;
            q.next = newNode;
            newNode.next = p;
        }
    }

    public void deleteByNode(Node p) {
        if(p == null || head == null) return;
        if(p == head) {
            head = head.next;
            return;
        }
        Node q = head;
        while( q != null && q.next != p ) {
            q = q.next;
        }

        if(q == null) return;

        q.next = q.next.next;
    }


    public  void deleteByValue(int value) {
        if(head == null) return;
        Node p = head;
        Node q = null;
        while( p != null && p.data != value) {
            q = p;
            p = p.next;
        }
        if(p == null ) return;

        if(q == null) {
            head = head.next;
        }else {
            q.next = p.next;
        }
    }

    public void printAll() {
        Node p = head;
        while( p != null) {
            System.out.println(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
    //判断 两个链表的值是否相等 true or false
    public boolean TFResult(Node left,Node right) {
        Node l = left;
        Node r = right;
        boolean flag = true;
        System.out.println("left_:"+l.data);
        System.out.println("right_"+r.data);
        while(l !=null && r !=null) {
            if(l.data ==  r.data) {
                l = l.next;
                r = r.next;
                continue;
            }else {
                flag = false;
                break;
            }
        }

        System.out.println("什么结果:");
        return flag;
    }

    //判断是否回文
    public boolean palindrome(){
        if(head == null) {
            return false;
        }else {
            System.out.println("开始执行找到中间结点");
            Node p = head;
            Node q = head;
            if(p.next == null) {
                System.out.println("只有一个元素");
                return true;
            }
          while(q.next != null && q.next.next != null) {
              p = p.next;
              q= q.next.next;
          }
            System.out.println("中间结点" + p.data);
            System.out.println("开始执行奇数结点的回文判断");
            Node leftLink = null;
            Node rightLink = null;
            if(q.next == null) {
                //p 一定为整个链表的中点
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
                System.out.println("左边第一个结点:" + leftLink.data);
                System.out.println("右边的第一个结点:" + rightLink.data);
            }else {
                //结点数目为偶数
                rightLink = p.next;
                leftLink = inverseLinkList(p);

            }
            return  TFResult(leftLink,rightLink);
        }

    }

    //带结点的链表翻转
    public Node inverseLinkList_head(Node p ) {
        //Head 为新建的一个头结点
        Node Head = new Node(9999,null);
        /*
            带头结点的链表翻转等价于
            从第二个元素开始重新头插法简历链表
        * */
        Node cur = p.next;
        p.next = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = Head.next;
            Head.next = cur;
            System.out.println("first" + Head.data);
            cur = next;
        }

        return head;
    }

    //无头结点的链表翻转
    public Node inverseLinkList(Node p) {
        Node pre = null;
        Node r = head;
        System.out.println("z---" + r.data);
        Node next= null;
        while(r !=p){
            next = r.next;

            r.next = pre;
            pre = r;
            r = next;
        }

        r.next = pre;
        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return r;
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node{
        private int data;
        private Node next;

       public Node(int data,Node next) {
           this.data = data;
           this.next = next;
       }
       public int getData() {
           return  data;
       }
    }

    public static void main(String[] args) {
        SinglyLinkedList link = new SinglyLinkedList();

        int data[] = {1,2,5,2,1};

        for (int i = 0; i < data.length; i++) {
            link.insertTail(data[i]);
        }
        link.printAll();

        if(link.palindrome()) {
            System.out.println("回文");
        }else {
            System.out.println("不是回文");
        }



    }

}
