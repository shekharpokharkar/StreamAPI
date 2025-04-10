package com.shekhar.functionalinterface;

public class Test {

	public static void main(String[] args) {

		Addition add = (a, b) -> {
			return a + b;
		};
		int sum = add.sum(10, 20);
		System.out.println(sum);

		System.out.println("============+++++++++++++++=====");
		Multiply mul = (a, b) -> a * b;
		Double product = mul.product(10.00, 10.00);
		System.out.println("Product Of This two:" + product);
	}
}
