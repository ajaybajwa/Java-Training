package com.hcl.assignment_four;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSetToArray {

	public static void main(String[] args) {
		// Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6));//Works

		Set<Integer> set = new HashSet<>();
		Collections.addAll(set, 1, 2, 3, 4, 5, 6, 6, 6, 6);
		System.out.println("Set: " + set.toString());

		set.toArray();
		System.out.println("After conversion to array: " + set);
	}
}
