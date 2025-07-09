package com.seleniumexpress.gropByVsPartisionBy;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntegerExample {

	public static void main(String[] args) {

		List<Integer> arrList = List.of(10, 11,10,12, 12, 13, 14, 1, 5, 11, 12, 16, 17, 18, 19, 20, 10, 1);

		List<Integer> collect = arrList.stream().distinct().collect(Collectors.toList());
		System.out.println(collect);

		Map<Integer, Long> collect2 = arrList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(collect2);

	}

}
