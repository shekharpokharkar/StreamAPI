package com.shekhar;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test8 {

	public static void main(String[] args) {

		System.out.println("Given a list of lists of integers, flatten the list and find all unique numbers");

		List<List<Integer>> listOfLists = Arrays.asList(
				Arrays.asList(1, 2, 3,4,7,5),
				Arrays.asList(4, 5, 6),
				Arrays.asList(7, 8, 9));

		
		Set<Integer> collect = listOfLists.stream().flatMap(List::stream).collect(Collectors.toSet());
		System.out.println(collect);
	}

}
