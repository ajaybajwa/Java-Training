package com.hcl.Assignment_two;

import java.util.Scanner;

public class SwapVariables {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter value of 'a'");
		int a = scanner.nextInt();
		System.out.println("Enter value of 'b'");
		int b = scanner.nextInt();
		
		int temp = a;
		a = b;
		b =  temp;
		
		System.out.println("Values after swap.\na = " +a + "\nb = " +b);
	}
}
