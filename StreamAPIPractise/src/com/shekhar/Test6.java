package com.shekhar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test6 {

	public static void main(String[] args) {

		System.out.println("Count how many words in a list start with the letter 'a'.");
		List<String> words = Arrays.asList("apple", "banana", "avocado", "grape", "apricot");

		Long collect = words.stream().filter(words1 -> String.valueOf(words1).startsWith("a"))
				.collect(Collectors.counting());
		System.out.println("No of Occurance is:" + collect);

	}

}
