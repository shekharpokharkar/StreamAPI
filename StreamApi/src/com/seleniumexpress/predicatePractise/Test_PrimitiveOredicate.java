package com.seleniumexpress.predicatePractise;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class Test_PrimitiveOredicate {

	public static void main(String[] args) {

		int Arr[] = { 11, 12, 13, 14, 15, 16 };

		Arrays.stream(Arr).filter(new IntPredicate() {

			@Override
			public boolean test(int value) {

				return value > 15;
			}
		}).forEach(s -> System.out.println(s));

		System.out.println("**************************");

		int ino1 = 25;

		IntPredicate itest = (value)-> value < 60;
		boolean test = itest.test(ino1);
		System.out.println(test);

	}

}
