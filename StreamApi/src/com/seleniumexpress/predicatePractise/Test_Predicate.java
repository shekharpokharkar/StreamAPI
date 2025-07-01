package com.seleniumexpress.predicatePractise;

import java.util.function.Predicate;

public class Test_Predicate {

	public static void main(String[] args) {

		Predicate<Integer> iNo3 = ((iNo) -> {

			System.out.println("Inside predicate iNo3");
			return iNo % 3 == 0;

		});

		Predicate<Integer> iNo5 = ((iNo) -> {

			System.out.println("Inside predicate iNo5");
			return iNo % 5 == 0;

		});

		// Default Methods
		Predicate<Integer> and = iNo3.and(iNo5);
		Predicate<Integer> or1 = iNo3.or(iNo5);
		Predicate<Integer> negate = iNo3.negate();
		boolean test = negate.test(25);
		
		
		// static methods
		Integer iNo = 10;
		Predicate<Integer> equal = Predicate.isEqual(iNo);

		System.out.println(equal.test(10)); // true
		System.out.println(equal.test(5));  // false
	
		
		if (test) {
			System.out.println("No is divisble by 3 and 5");
		} else {
			System.out.println("No is not divisble by 3 and 5");
		}

	}

}
