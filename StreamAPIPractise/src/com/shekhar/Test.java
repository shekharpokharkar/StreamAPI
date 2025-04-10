package com.shekhar;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		System.out.println("Count the Character");

		String str = "shekhar";

		LinkedHashMap<Character, Long> collect = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		collect.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + "=====" + entry.getValue()));

	}

}
