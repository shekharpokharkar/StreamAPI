package com.seleniumexpress.gropByVsPartisionBy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * 
 * 
 * 
 * 
✅ 1. Use Streams for Collection Processing
Stream API is designed for working with collections, not necessarily for simple one-liners.

✔️ Best use cases:
Filtering, mapping, grouping

Aggregating (sum, average, max)

Sorting, partitioning, deduplicating

Chaining multiple transformations
 
 * 
 */
public class StringExample {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {

		List<String> strList = List.of("Rohan", "Pokharkar", "Dipak", "Shekhar", "Komal", "Rayan", "Rohan", "Komal");

		System.out.println("Find the longest string");

		Map<String, Long> collect = strList.stream().collect(Collectors.groupingBy(String::new, Collectors.counting()));
		System.out.println(collect);

		System.out.println("How to find only duplicate elements");

		long count = collect.entrySet().stream().filter(entry -> entry.getValue() >= 2).count();
		System.out.println("No of duplicate elemenrts :" + count);

		System.out.println("Count the number of character");
		Map<String, List<Integer>> collect2 = strList.stream()
				.collect(Collectors.groupingBy(String::new, Collectors.mapping(String::length, Collectors.toList())));

		System.out.println(collect2);
		System.out.println("************************");
		collect2.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

		System.out.println("**************");
		Map<String, Integer> collect3 = strList.stream().distinct()
				.collect(Collectors.toMap(str -> str, String::length));
		System.out.println(collect3);

		System.out.println("Sort the list by using length ise and then alphabetically");

		List<String> list = strList.stream()
				.sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())).toList();

		System.out.println(list);

		System.out.println("Find the frequenncy of each character in the string");

		String str = "shekhar ramdas pokharkar";

		Map<Character, Long> collect4 = str.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Character::new, Collectors.counting()));

		System.out.println(collect4);

		System.out.println("UpperCase the first letter of the word using stream");

		String[] split = str.split(" ");

		List<String> collect5 = Arrays.asList(split).stream()
				.map(str1 -> str1.substring(0, 1).toUpperCase() + str1.substring(1, str1.length()).toLowerCase())
				.collect(Collectors.toList());

		System.out.println(collect5);

		System.out.println("Reverse each word");

		String collect6 = Arrays.asList(split).stream().map(str1 -> new StringBuffer(str1).reverse().toString())
				.collect(Collectors.joining(" "));

		System.out.println(collect6);

		System.out.println("Reverse An integer array");

		int arr[] = { 10, 11, 12, 13, 14, 15, 16 };

		System.out.println(Arrays.toString(arr));
		int[] array = IntStream.range(1, arr.length).map(a -> arr[arr.length - a]).toArray();

		System.out.println("After" + Arrays.toString(array));

		List<String> list2 = Stream.of("Apple", "LG", "SAMSUNG", "OPPO", "IPHONE", "ONE PLUS", "LG", "SAMSUNG", "OPPO")
				.distinct().toList();

		System.out.println(list2);

		Set<String> collect7 = Stream
				.of("Apple", "LG", "SAMSUNG", "OPPO", "IPHONE", "ONE PLUS", "LG", "SAMSUNG", "OPPO")
				.collect(Collectors.toSet());

		System.out.println(collect7);

		System.out.println("Merging two unsorted Arrays into one using Java8 Stream way");

		int Arr[] = { 7, 5, 4, 2, 1, 8, 9, 50 };

		int Brr[] = { 11, 15, 42, 10, 15, 11, 50, 7, 5, 2, 1, 98 };

		Integer[] collect8 = Stream.concat(Arrays.stream(Arr).boxed(), Arrays.stream(Brr).boxed()).collect(Collectors
				.collectingAndThen(Collectors.toCollection(TreeSet::new), set -> set.toArray(new Integer[0])));

		System.out.println(Arrays.toString(collect8));

		int Crr[] = { 22, 23, 17, 77, 156, 123 };

		Double collect9 = Arrays.stream(Crr).boxed().filter(iNo -> iNo % 2 == 0)
				.collect(Collectors.averagingInt(Integer::new));

		System.out.println("Average of All integer is:" + collect9);

		System.out.println("*************************************");

		double asDouble = IntStream.of(Crr).filter(t -> t % 2 == 0).average().getAsDouble();

		System.out.println("Average:" + asDouble);

		Stream.of(

				Arrays.asList(11, 22, 33), Arrays.asList(55, 66, 77, 88), Arrays.asList(99, 21, 34))
				.flatMap(List::stream).collect(Collectors.toList());

		List<String> collect10 = List.of("shekhar", "Ram", "shyam", "Pokharkar", "ABC", "Yadav", "lkhgfd").stream()
				.sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
		System.out.println(collect10);

		String checkPallindrome = "refer";

		boolean equals2 = new StringBuilder(checkPallindrome).reverse().toString().equals(checkPallindrome);

		String collect11 = checkPallindrome.chars().mapToObj(c -> (char) c).collect(Collectors.collectingAndThen(

				Collector.of(StringBuilder::new, // 1. supplier
						StringBuilder::append, // 2. accumulator
						StringBuilder::append, // 3. combiner
						StringBuilder::toString // 4. finisher
				), s -> new StringBuilder(s).reverse().toString()));

		boolean equals = collect11.equals(checkPallindrome);
		if (equals) {
			System.out.println("Pallindrome");
		} else {
			System.out.println("Not Pallindrome");
			
		}
		
		
		
		boolean noneMatch = IntStream.range(0,checkPallindrome.length()/2)
		.noneMatch(i->checkPallindrome.charAt(i) != checkPallindrome.charAt(checkPallindrome.length()-i-1));
	}

}
