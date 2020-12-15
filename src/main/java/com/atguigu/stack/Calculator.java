package com.atguigu.stack;
/*1. 通过一个 index  值（索引），来遍历我们的表达式
2. 如果我们发现是一个数字, 就直接入数栈
3. 如果发现扫描到是一个符号,  就分如下情况
3.1 如果发现当前的符号栈为 空，就直接入栈
3.2 如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符， 就需要从数栈中pop出两个数,在从符号栈中pop出一个符号，进行运算，将得到结果，
 入数栈，然后将当前的操作符入符号栈， 如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈.
4. 当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行.
5. 最后在数栈只有一个数字，就是表达式的结果
*
*
* */
public class Calculator {
    public static void main(String[] args) {
        String expression = "121*23+32-41";
        //创建两个栈，数栈和符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; //将每次扫描得到char保存到ch
        String keepNum =""; //用于拼接，多位数
        while(true) {
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch是什么，做出相应的处理
            if(operStack.isOper(ch)) {
                if(!operStack.isEmpty()){
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num2,num1,oper);
                        //把运算的结果入数栈
                        numStack.push(res);
                        //然后将当前操作符入符号栈
                        operStack.push(ch);
                    }else{
                        operStack.push(ch);
                    }
                }else {
                    operStack.push(ch);
                }



            }else {
                //1. 当处理多位数时，不时发现一个数就直接入栈
                //2.
                keepNum += ch;
                //如果ch已经时expression的最后一为,就直接入栈
                if(index == expression.length()-1) {
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    //判断下一位时不时数字，如果时数字就继续扫描。如果是运算符就入栈
                    //注意是看最后一位，不是index++
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum ="";
                    }
                }
            }
            //index+1,并判断是否扫描到expression的最后
            index++;
            if(index >= expression.length()) {
                break;
            }
        }
        //当表达式扫描完成后，就顺序的出栈进行运算
        while (true) {
            if(operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = operStack.cal(num2,num1,oper);
            numStack.push(res);
        }

        int res2 = numStack.pop();
        System.out.println("表达式"+expression+"的计算结果是:" + res2);

    }
}
//创建一个ArrayStack栈
class ArrayStack2{
    private int maxSize;
    private int[] stack;
    private int top = -1;   //栈顶初始化为-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public int peek(){
        return stack[top];
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
    //返回运算符的优先级
    //数字
    public int priority(int oper) {
        if(oper == '*' || oper == '/') {
            return 1;
        }else if(oper == '+' || oper == '-') {
            return 0;
        }else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2,int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return  res;
    }

}