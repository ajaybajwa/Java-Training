package com.hcl.assignment_two;

import java.util.Scanner;

public class IntegersSum {

	static boolean checkSum(int a, int b, int c) {
		if (c == a + b) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first integer");
		int a = scanner.nextInt();
		
		System.out.println("Enter second integer");
		int b = scanner.nextInt();
		
		System.out.println("Enter third integer");
		int c = scanner.nextInt();
		
		System.out.println("The result is " +
		IntegersSum.checkSum(a, b, c));
	}
}
