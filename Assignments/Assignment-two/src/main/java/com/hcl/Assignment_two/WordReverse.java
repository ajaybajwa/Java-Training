package com.hcl.Assignment_two;

import java.util.Scanner;

public class WordReverse {
	
	public static void reverse(String word) {
		
		char[] arr = new char[word.length()];
		arr = word.toCharArray();
		
		System.out.println("The reversed word is: ");
		
		for(int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
				
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the word to be reversed");
		reverse(scanner.nextLine());
	}
}
