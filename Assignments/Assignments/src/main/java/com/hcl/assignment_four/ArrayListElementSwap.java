package com.hcl.assignment_four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.transform.Source;

public class ArrayListElementSwap {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("Tom", "Jerry", "Mickey", "Stuart"));
		Iterator i = list.iterator();
		System.out.println("Before swap:");
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		Collections.swap(list, 0, 1);

		Iterator it = list.iterator();
		System.out.println("\nAfter swap:");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
