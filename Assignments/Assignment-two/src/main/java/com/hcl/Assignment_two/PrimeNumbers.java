package com.hcl.Assignment_two;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter no. of prime numbers you want");
		int n = scanner.nextInt();
		scanner.close();
		
		int c = 0;
		int num = 2;
		
		while(c != n ) {
			int flag = 1;
				for (int i = 2; i <= Math.sqrt(num); i++) {
					if (num % i ==0) {
						flag = 0;
						break;
					}
				}
				if (flag == 1) {
					c++;
					System.out.print(num +" ");
				}
				num++;
			}
	}
}
