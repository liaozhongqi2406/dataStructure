package com.atguigu.linkedList;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(10,25,125);
    }
}

class CircleSingleLinkedList{
    //创建第一个first
    private Boy first = null;
    //添加小孩节点，构建一个环形链表
    public void addBoy(int nums) {
        if(nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null; //辅助指针,帮助构建环形链表
        for (int i = 1; i < nums +1 ; i++) {
            Boy boy = new Boy(i);
            if(i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }
    //遍历当前的环形链表
    public void showBoy() {
        if(first == null) {
            System.out.println("没有任何小孩~~~~~");
            return;
        }
        Boy cur = first;
        while(true) {
            System.out.println(cur);
            if(cur.getNext() == first) {
                break; // 说明已经遍历完毕
            }
            cur = cur.getNext();
        }
    }

    public void  countBoy(int startNo, int countNum, int nums) {
        if(first == null || startNo <1 || startNo >nums) {
            System.out.println("输入参数有无，请重新输入");
            return;
        }
        Boy helper = first;
        //需要创建一辅助指针，指向环形链表的最后这个节点
        while(true) {
            if(helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前,先让first和helper 移动k-1次
        for (int i = 0; i < startNo -1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩报数是，让first和helper同时移m-1次，然后出圈
        while (true) {
            if(helper == first) {  //说明圈中只有一个节点
                break;
            }
            for (int i = 0; i < countNum -1 ; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("出圈的小孩" + first);

            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩编号+"+first);


    }



}
class Boy{
    private int no; //编号
    private Boy next;

    public  Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}