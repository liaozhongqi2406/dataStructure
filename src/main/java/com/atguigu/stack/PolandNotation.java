package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String expression = "12+((21+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的list=" + infixExpressionList);
        List<String> suffixExpressionList = parseSuffoxExpreesion(infixExpressionList);
        System.out.println("后缀表达是对应的List" + suffixExpressionList);

        System.out.println("计算记过" + calculate(suffixExpressionList));


/*        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        List<String> list = getListString(suffixExpression);
        System.out.println("rpnList=" +list);
        int res = calculate(list);
        System.out.println(res);*/
    }

    // 方法：将对应的中缀表达式转换成后缀表达式
    private static List<String> parseSuffoxExpreesion(List<String> ls) {
        Stack<String> s1 = new Stack<>();
        // s2整个栈是没必要存在的，用list代替即可
        List<String> s2 = new ArrayList<>();
        //遍历ls
        for (String item : ls) {
            if(item.matches("\\d+")) {
                s2.add(item);
            }else if(item.equals("(")) {
                s1.push(item);
            }else if(item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();  // 将（弹出 消除（
            }else {
              while(s1.size() !=0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                  s2.add(s1.pop());
              }
              s1.push(item);
            }
        }
        while (s1.size()!=0) {
            s2.add(s1.pop());
        }
        return s2;
    }


    //将中缀表达式转成对应的list
    private static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<>();
        int i = 0;
        //没有考虑到多位数的情况
//        char[] chars = expression.toCharArray();
//        for (char c : chars) {
//            ls.add(String.valueOf(c));
//        }
//        return ls;
        String str;
        char c;
        do{
            //如果是非数字，直接加入到ls中
            if((c =s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++; //将i后移
            }else {
                //如果是一个数，需要考虑到多为数的情乱
                str = "";
                while( i < s.length() && (c=s.charAt(i)) >=48 && (c=s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while (i < s.length());
        return ls;
    }

    private static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if(item.matches("\\d+")) {
                stack.push(item);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")) {
                    res = num1 + num2;
                }else if(item.equals("-")) {
                    res = num1 - num2;
                }else if(item.equals("*")) {
                    res = num1 * num2;
                }else if(item.equals("/")) {
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
           list.add(ele);
        }
        return list;
    }

}

class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 1;
    private static int DIV = 1;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符" + operation);
                break;
        }
        return result;
    }

}