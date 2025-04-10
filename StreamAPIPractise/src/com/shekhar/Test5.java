package com.shekhar;

import java.util.Arrays;
import java.util.List;

public class Test5 {

	public static void main(String[] args) {

		System.out.println("calculate the product of all numbers in the list");
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		Integer integer = numbers.stream().reduce((a, b) -> a * b).get();
		System.out.println("Product of this all NUmber is:" + integer);
	}

}
