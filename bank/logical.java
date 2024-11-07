package com.org.bank;
public class logical{
public static void main(String[] args) {
    int a = 10;
    int b = 20;
    int c = 30;
    System.out.println("(a < b) && (b < c): " + ((a < b) && (b < c))); 
    System.out.println("(a > b) && (b < c): " + ((a > b) && (b < c))); 
    System.out.println("(a < b) || (b > c): " + ((a < b) || (b > c))); 
    System.out.println("(a > b) || (b > c): " + ((a > b) || (b > c))); 
}
}


