package com.shekhar;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test7 {

	public static void main(String[] args) {

		System.out.println(
				"Group a list of strings by their length (i.e., group strings with the same length together).");
		List<String> words = Arrays.asList("apple", "banana", "pear", "peach", "kiwi");

		Map<Integer, List<String>> collect = words.stream().collect(Collectors.groupingBy(String::length,Collectors.toList()));
		
		System.out.println(collect);
		
	}
}
