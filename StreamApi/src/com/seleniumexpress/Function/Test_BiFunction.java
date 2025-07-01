package com.seleniumexpress.Function;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

public class Test_BiFunction {

	public static void main(String[] args) {

		BiFunction<Integer, Integer, Integer> ifunction1 = ((ivalue1, ivalue2) -> {
			System.out.println("Inside function 1");
			return ivalue2 - ivalue1;
		});
		Function<Integer, Integer> ifunction2 = ((ivalue1) -> {
			System.out.println("Inside function 2");
			return ivalue1;
		});

		BiFunction<Integer, Integer, Integer> andThen = ifunction1.andThen(ifunction2);
		Integer result = andThen.apply(150, 350);
		System.out.println(result);

		IntFunction<Integer> ino1 = new IntFunction<Integer>() {

			@Override
			public Integer apply(int value) {

				return Integer.valueOf(value);
			}
		};

		Integer apply = ino1.apply(101);
		System.out.println(apply);

		IntToDoubleFunction i1 = new IntToDoubleFunction() {

			@Override
			public double applyAsDouble(int value) {

				return 0;
			}
		};

		ToIntFunction<Long> i2 = new ToIntFunction<Long>() {

			@Override
			public int applyAsInt(Long value) {
				// TODO Auto-generated method stub
				return 0;
			}
		};

		ToDoubleFunction<Integer> i3 = new ToDoubleFunction<Integer>() {

			@Override
			public double applyAsDouble(Integer value) {
				// TODO Auto-generated method stub
				return 0;
			}
		};

	}
}
