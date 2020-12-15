package com.atguigu.linkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向列表的测试");

        HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3,"无用","智多星");
        HeroNode2 hero4 = new HeroNode2(4,"李丛","豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();

        HeroNode2 newHeroNode = new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedList.update(newHeroNode);
        doubleLinkedList.list();

        doubleLinkedList.del(3);
        doubleLinkedList.list();



    }
}
class DoubleLinkedList{

   private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }

    //显示链表
    public void  list() {
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while(true) {
            if(temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加一个节点到双向链表的最后
    public void add(HeroNode2 heroNode) {

        HeroNode2 temp = head;
        //
        while (true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void update(HeroNode2 newHeroNode) {
        if(head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode2 temp = head.next;
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

    //从双向链表中删除一个节点   我们只需要找到需要删除的节点即可
    public void del(int no) {
        if(head.next == null) {
            System.out.println();
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true) {
            if(temp == null) {
                break;
            }
            if(temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            temp.pre.next = temp.next;
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("要删除的节点不存在");
        }
    }

}

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;  //指向下一个结点
    public HeroNode2 pre;  //指向前一个结点

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

