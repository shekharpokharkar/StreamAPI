package com.seleniumexpress;

public interface A {

	default void m1() {
		System.out.println("Inside Default method A interface");
	}

	public static void m() {
		System.out.println("Inside static method of m");
	}
}
