package com.seleniumexpress.gropByVsPartisionBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorOf_Test {

	public static void main(String[] args) {

		// Collector.of(
		// Supplier<A>,Creates the result container
		// BiConsumer<A, T>,Accumulates a value into the container
		// BinaryOperator<A>,Combines two containers (parallel stream)
		// Function<A, R> Final transformation of result

		System.out.println("Join all words into a sentence (space separated)");
		List<String> words = List.of("Java", "Streams", "are", "powerful");

		String collect = words.stream().collect(Collectors.joining(" "));

		System.out.println(collect);

		String sentence = words.stream().collect(Collector.of(StringBuilder::new, // supplier
				(sb, word) -> sb.append(word).append(" "), // BiCosumer
				StringBuilder::append, // BinaryOperator
				sb -> sb.toString().trim()));

		System.out.println(sentence);

		System.out.println("Build String with Custom Prefix and Suffix");
		List<String> words1 = List.of("Java", "Streams", "are", "powerful");

		System.out.println("***********************************");

		

	}

}
