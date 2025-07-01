package com.seleniumexpress.predicatePractise;

import java.util.function.BiPredicate;

public class Test_Bipredicate {

	public static void main(String[] args) {

		BiPredicate<Integer, Integer> check = (iNo1, iNo2) -> (iNo1 * iNo2) / 5 == 0;
		boolean test = check.test(35, 40);
		System.out.println(test);
	}

}
