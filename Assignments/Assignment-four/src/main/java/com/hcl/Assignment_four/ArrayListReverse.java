package com.hcl.Assignment_four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListReverse {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		list = Arrays.asList(1, 2, 3, 4, 5, 6);
		Collections.reverse(list);

		for (int i : list) {
			System.out.println(i);
		}

	}
}
