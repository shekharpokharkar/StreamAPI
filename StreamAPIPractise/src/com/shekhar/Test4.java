package com.shekhar;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Test4 {

	public static void main(String[] args) {

		System.out.println("find the sum of all even numbers");
		
		List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35);
		
		IntSummaryStatistics ino1=numbers.stream().filter(ino->ino%2 == 0).collect(Collectors.summarizingInt(Integer::new));

		System.out.println("Sum is:"+ino1.getSum());

	}

}
