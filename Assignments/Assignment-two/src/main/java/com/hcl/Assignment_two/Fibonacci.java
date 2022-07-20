package com.hcl.Assignment_two;

import java.io.InputStream;
import java.util.*;
public class Fibonacci 
{
	
    public static void main( String[] args )
    {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter the value.");
    	int n = scanner.nextInt();
    	
    	int[] arr = new int[n];
    	
    	
    	
    	for (int i = 0; i<n;i++) {
    		if (i<=1) {
    			arr[i] = i;
    		}
    		else {
    			arr[i] = arr[i-1] + arr[i-2];
    		}
    		System.out.print(arr[i] +" ");
    		
    	}
    	
        
    }
}
