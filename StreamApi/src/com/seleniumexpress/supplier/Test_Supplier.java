package com.seleniumexpress.supplier;

import java.util.function.BinaryOperator;
import java.util.function.IntSupplier;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Test_Supplier {

	public static void main(String[] args) {

		UnaryOperator<Integer> i1 = new UnaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return null;
			}
		};

		UnaryOperator<Integer> i2 = new UnaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t) {

				return null;
			}
		};

		BinaryOperator<Double> i3 = new BinaryOperator<Double>() {

			@Override
			public Double apply(Double t, Double u) {

				return t+u;
			}
		};
	}
}
