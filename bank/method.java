package com.org.bank;
public class method {
    public int add() {
        int a = 20;
        int b = 2;
        return a + b;
    }
    public void multi() {
        int a = 30;
        int b = 4;
        System.out.print(a * b);  
    }
 public static void main(String[] args) {
        method me = new method();
        int sum = me.add();
        System.out.println("Sum: " + sum);
        me.multi();
    }
}
