package com.seleniumexpress.streamApiExample;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class StreamCreation {
	
	public static void main(String[] args) {
		
		Integer arr[]= {10,12,13,4,15,16};
		Stream<Integer> stream = Arrays.stream(arr);
		
		Stream<String> stream2 = Stream.of("Sp","VP","KP","TY");
		
		Stream.Builder<Integer> builder = (Builder<Integer>) Stream.builder().add(10).add(20).build();
		
		Stream<Integer> stream4 = Stream.generate(()-> 11).limit(10);
		
		
		 
	}

}
