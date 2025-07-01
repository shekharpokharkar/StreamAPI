package com.seleniumexpress.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Test_Consumer {

	public static void main(String[] args) {

		BiConsumer<Integer, Integer> ino3 = (ino1, ino2) -> System.out.println(ino1 + ino2);

		Consumer<Integer> ino2 = ((ino) -> {
			System.out.println("Inside consumer 2");
			System.out.println(ino);
		});

		/* Consumer<Integer> andThen = ino1.andThen(ino2); */
		/*
		 * andThen.accept(25);
		 */
	}

}
