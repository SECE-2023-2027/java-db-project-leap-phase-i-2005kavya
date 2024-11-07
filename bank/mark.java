package com.org.bank;
import java.util.*;
public class mark{
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your marks: ");
		int marks = scanner.nextInt();
		String grade;
        if (marks < 30) {
           System.out.println(grade = "F");
        } 
        else if (marks >= 30 && marks < 50) {
        	System.out.println( grade = "D");
        }
        else if (marks >= 50 && marks < 70) {
        	System.out.println(grade = "C");
        }
        else if (marks >= 70 && marks < 90) {
        	System.out.println (grade = "B");
        } 
        else if (marks >= 90) {
        	System.out.println(grade = "A");
        }
        else {
        	System.out.println( grade = "Invalid marks entered.");
        }
        
	}
}
