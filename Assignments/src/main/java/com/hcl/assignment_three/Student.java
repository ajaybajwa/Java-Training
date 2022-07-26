package com.hcl.assignment_three;

import javax.naming.spi.DirStateFactory.Result;

public class Student {
	
	static String Average(int exam1, int exam2, int exam3) {
		float avg = (exam1 + exam2 + exam3)/3;
		if (avg>50) {
			return "passed";
		}
		else {
			return "failed";
		}
	}
	
	static String Input(String name) {
		return name;
	}
	
	public static void main(String[] args) {
		Student s1 = new Student();
		String s1Name = s1.Input("Peter");
		String s1Result = s1.Average(40, 30, 60);
		System.out.println(s1Name +" has " +s1Result);
		
		System.out.println(Input("Tom") + " has "+Average(60, 70, 40));
		
	}
}
