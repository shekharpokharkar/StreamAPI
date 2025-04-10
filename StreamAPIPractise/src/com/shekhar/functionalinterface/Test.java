package com.shekhar.functionalinterface;

public class Test {

	public static void main(String[] args) {
		
		
		Addition add=(a,b)->{return a+b;};
		int sum = add.sum(10,20);
		System.out.println(sum);
	}
}
