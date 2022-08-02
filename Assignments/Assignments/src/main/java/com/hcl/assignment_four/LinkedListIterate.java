package com.hcl.assignment_four;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListIterate {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		System.out.println("Full List: " + list.toString());

		System.out.print("From index 4: ");
		Iterator i = list.listIterator(4);
		while (i.hasNext()) {
			System.out.print(" " + i.next());
		}
	}
}
