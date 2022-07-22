package com.hcl.Assignment_four;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListElementReplace {

	public static void main(String[] args) {
		List<String> list = new LinkedList();
		list = Arrays.asList("Tom", "Jerry", "Mickey", "Stuart", "Pooh");
		System.out.println("Full List: " + list.toString());

		list.set(4, "Donald");
		list.set(list.indexOf("Stuart"), "Teddy");
		System.out.println("Updated List: " + list.toString());

	}
}
