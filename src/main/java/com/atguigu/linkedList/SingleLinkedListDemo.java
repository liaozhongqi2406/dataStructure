package com.atguigu.linkedList;

import com.sun.org.apache.bcel.internal.generic.SIPUSH;

import java.sql.SQLOutput;
import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        /*singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.list();

        HeroNode newHeroNode = new HeroNode(2,"小卢","金麒麟");
        singleLinkedList.update(newHeroNode);

        System.out.println("修改后的链表............");
        singleLinkedList.list();

        singleLinkedList.del(1);
        singleLinkedList.del(2);

        System.out.println("删除后的链表");
        singleLinkedList.list();*/

        System.out.println(getLength(singleLinkedList.head));
//        System.out.println(findLastIndexNode(singleLinkedList.head,2));

        /*reverse(singleLinkedList.head);
        singleLinkedList.list();*/
        reversePrint(singleLinkedList.head);


    }
    //获取单链表的有效结点个数
    public static int getLength(HeroNode head) {
        if(head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length ++;
            cur = cur.next;
        }
        return length;
    }

    //查找单链表的倒数第k个结点
    public static HeroNode findLastIndexNode(HeroNode head,int index) {
        if(head.next == null) {
            return null;
        }
        int size = getLength(head);
        if(index <=0 || index >size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i =0 ;i<size-index ;i++) {
            cur = cur.next;
        }
        return cur;
    }

    //单链表的反转

    public static void reverse(HeroNode head) {
        //空链表或只有一个结点的链表不需要反转
        if(head.next == null || head.next.next == null) {
            return;
        }
        HeroNode reve = new HeroNode(0,"","");
        HeroNode cur = head.next;
        while( cur !=null ) {
            head.next = cur.next;
            cur.next = reve.next;
            reve.next = cur;
            cur = head.next;
        }

        head.next = reve.next;
    }
    public static  void reversePrint(HeroNode head) {
        if(head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while(stack.size()>0) {
            System.out.println(stack.pop());
        }
    }

}
class SingleLinkedList{
    //初始化头结点，头节点不存放具体的数据
    public HeroNode head = new HeroNode(0,"","");

    //添加结点到单向列表
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while(true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //从小到大的方式进行插入
    public  void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;  //flag标志添加的编号是否存在，默认为false
        while(true) {
            if(temp.next == null) {
                break;
            }
            if(temp.next.no >heroNode.no) {
                break;
            }else if (temp.next.no == heroNode.no) {
                flag =true;
                break;

            }
            temp = temp.next;
        }
        //判断flag的值，存在就不能添加
        if(flag) { //不能添加，说明编号已存在
            System.out.println("准备插入的英雄编号已存在");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }
    //修改结点的信息
    public void update(HeroNode newHeroNode) {
        if(head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;  //表示是否找到该结点
        while(true) {
            if(temp == null) {
                break;
            }
            if(temp.no == newHeroNode.no) {
                flag = true;
                break;
            }

            temp = temp.next;
        }
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.println("要修改的英雄不存在");
        }
    }
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while(true) {
            if(temp.next == null) {
                break;
            }
            if(temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.next = temp.next.next;
        }else {
            System.out.println("要删除的结点不存在");
        }
    }
    //显示列表
    public void list() {
        if(head.next == null) {
            System.out.println("链表为空。。。");
            return;
        }
        HeroNode temp = head.next;
        while(true) {
            System.out.println(temp);
            temp = temp.next;
            if(temp == null) {
                break;
            }
        }
    }

}

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
