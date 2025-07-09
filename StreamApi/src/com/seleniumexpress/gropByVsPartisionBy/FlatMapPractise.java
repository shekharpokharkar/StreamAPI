package com.seleniumexpress.gropByVsPartisionBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapPractise {

	public static void main(String[] args) {

		List<List<Integer>> asList = Arrays.asList(Arrays.asList(10, 11, 12, 13, 14), Arrays.asList(10, 11, 12, 13, 14),
				Arrays.asList(10, 11, 12, 13, 14));

		System.out.println("Pararllel Stream");

		Integer integer =
				asList
				.parallelStream()
				.flatMap(t -> t.stream())
				.reduce((t, u) -> {return t + u;})
				.get();

		System.err.println("Sum:" + integer);

		List<Integer> list = asList.stream().flatMap(t -> t.stream()).toList();
		System.out.println(list);

		List<Integer> list2 = asList.stream().flatMap(List::stream).toList();
		System.out.println(list2);

		List<String> asList3 = Arrays.asList("shekhar pokharkar", "Akshay Ganjale");
		System.out.println(asList3);

		Stream<String> stream = asList3.stream().flatMap(str -> Arrays.asList(str.split(" ")).stream());

		List<String> list3 = stream.peek(e->System.out.println(e)).toList();
		System.out.println(list3);
		
		
	}
}
