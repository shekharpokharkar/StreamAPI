package com.shekhar;

import java.util.stream.Collectors;

public class Test2 {

	public static void main(String[] args) {
		String str = "Shekhar@123";
		System.out.println("Check whether string contains special charcater or not");

		String collect = str.chars().mapToObj(c -> (char) c).filter(c -> Character.isLetterOrDigit(c))
				.map(s -> String.valueOf(s)).collect(Collectors.joining(""));

		System.out.println("String:" + collect);

	}

}
