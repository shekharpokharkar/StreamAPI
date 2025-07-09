package com.seleniumexpress.gropByVsPartisionBy;

import java.util.Arrays;
import java.util.List;

public class NumberTest {

	public static void main(String[] args) {

		List<Integer> asList = Arrays.asList(10, 11, 10, 12, 13, 4, 5, 12, 15, 1, 1, 4, 15, 12, 16, 50);
		System.out.println("ORIGINAL LIST");
		System.out.println(asList);

		System.out.println("**************************************");
		System.out.println("Find Out distinct Element");
		asList.stream().mapToInt(x -> x).distinct().forEach(ino -> System.out.print(ino + "-"));
		System.out.println("**************************************");
		System.out.println("Find Out Maximum  and minimum Element in list");

		Integer reduce = asList.parallelStream().reduce(
				0,//Initializer 
				Integer::sum,//accumulator
				Integer::sum);//combiner
		System.out.println("Sum of the all elements in list:" + reduce);

		String reduce2 = asList.stream().reduce(
				"Result=", //Initializer 
				(acc, num) -> acc + num + ",", //accumulator
				String::concat);//combiner
		System.out.println(reduce2);
	}

}
