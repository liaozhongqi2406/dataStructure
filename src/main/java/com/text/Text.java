package com.text;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

/**
 * @author LiaoZQ
 * @version 1.0
 * @date 2020/8/15 19:54
 */
public class Text {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("字符串输入");
        String str =sc.next();
        System.out.println("输入位置");
        int n = sc.nextInt();
        int m = str.length();
        if( n >= m || n < 1 || n >= 2000 || m >=2000)
            return ;
        char[] chars = str.toCharArray();
        for (int i = 0; i < m -n ; i++) {
            chars[i] =chars[n+i];
        }
        String substring = new String(chars,0,m-n);
        System.out.println(substring);

    }
}
