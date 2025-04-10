package com.shekhar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test9 {

	public static void main(String[] args) {

		System.out.println("Use a combination of filter, map, " + "and collect to get the list of squares of all "
				+ "even numbers in the list");

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		List<Integer> collect = numbers.stream().filter(s->s%2 == 0).map(ino->Math.multiplyExact(ino, ino)).collect(Collectors.toList());

		System.out.println(collect);
	}

}
