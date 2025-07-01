package com.seleniumexpress.Function;

import java.util.function.Function;

public class Test_Function {

	public static void main(String[] args) {

		Function<Integer, Integer> ifunction1 = ((ivalue) -> {
			System.out.println("Inside function 1");
			return ivalue - 25;
		});
		Function<Integer, Integer> ifunction2 = ((ivalue) -> {
			System.out.println("Inside function 2");
			return ivalue - 5;
		});
		Function<Integer, Integer> compose = ifunction1.compose(ifunction2);
		Integer apply = compose.apply(40);
		System.out.println(apply);

		Function<Integer, Integer> andThen = ifunction1.andThen(ifunction2);
		Integer result = andThen.apply(40);
		System.out.println(result);
	}
}
