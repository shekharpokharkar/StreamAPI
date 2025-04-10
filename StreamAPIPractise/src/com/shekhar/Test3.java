package com.shekhar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {

	public static void main(String[] args) {

		System.out.println("Given a list of strings, convert all strings to uppercase and print them");

		List<String> words = Arrays.asList("apple", "banana", "cherry");

		
		//List<String> list = words.stream().map(str->str.toUpperCase()).toList();
		
		
		 String collect = words.stream().map(str->str.toUpperCase()).collect(Collectors.joining(","));
		
		 System.out.println(collect);
		
		
	}

}
