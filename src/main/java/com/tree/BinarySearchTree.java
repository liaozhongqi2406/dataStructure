package com.tree;

import sun.plugin.liveconnect.OriginNotAllowedException;

import java.util.Date;

public class BinarySearchTree {

    private Node tree;

    //todo 查找
    public Node find(int data) {
        Node p = tree;
        while(p != null) {
            if(data < p.data) p = p.left;
            else if(data > p.data) p = p.right;
            else return p;
        }
        return null;
    }

    //todo 添加
    public void insert(int data) {
        //空树判断
        if(tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while( p != null) {
            if(data > p.data) {
                if(p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }else if(data < p.data) {
                if(p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }else {
                return;
            }
        }

    }
    //删除节点
    public void delete(int data) {
        Node p = tree;
        Node parent = null;
        while( p != null && p.data != data) {
            parent= p;
            if(data > p.data) p = p.right;
            else p = p.left;
        }
        if( p == null ) return;

        //要删除的节点有两个子节点
        if(p.left !=null && p.right != null) {
            Node minp = p.right;
            Node minpp = p;
            while(minp.left != null) {
                minpp = minp;
                minp = minp.left;
            }
            p.data = minp.data;//讲minp的数据替换到p中
            p = minp; // 下面就变成删除minp了
            parent = minpp;

            //删除节点是叶子节点或者仅有一个子节点
            Node child;
            if( p .left != null) child = p.left;
            else if ( p.right != null) child = p.right;
            else child = null;

            if( parent == null) tree = child; //删除的是根节点
            else if(parent.left == p )  parent.left = child;
            else parent.right = child;

        }

    }

    public Node findMin() {
        if (tree == null) return null;
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }


    public Node findMax() {
        if (tree == null) return null;
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }
    public static  class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
