package com.seleniumexpress;

public interface B {

	default void m1() {
		System.out.println("Inside Default method A interface");
	}

	public static void m2() {
		System.out.println("Inside static method of m");
	}
}
