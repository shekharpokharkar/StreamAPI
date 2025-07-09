package com.seleniumexpress.gropByVsPartisionBy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;

public class TestCollectors {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
		// "Even Numbers: 2, 4, 6"

		/*
		 * String collect = numbers.stream().filter(t -> t % 2 == 0)
		 * .collect(Collector.of(() -> new StringBuilder("Even Numbers:"), (sb, num) ->
		 * { if (sb.length() > "Even Numbers: ".length()) { sb.append(", "); }
		 * sb.append(num); }, (sb1, sb2) ->
		 * sb1.append(", ").append(sb2.substring("Even Numbers: ".length())),
		 * StringBuilder::toString));
		 * 
		 * System.out.println(collect);
		 */

		System.out.println("******************");

		String collect = numbers.stream().collect(Collector.of(TotalSum::new, (total, n) -> {
			total.isum += n;
			total.iproduct *= n;
		}, (total1, total2) -> {

			total1.isum += total2.isum;
			total1.iproduct += total2.iproduct;
			return total1;
		}, total -> "sum:" + total.isum + " product:" + total.iproduct));

		System.out.println(collect);

		System.out.println("**********************");

		String str = "abc";

		str.chars().mapToObj(c -> (char) c).filter(new Predicate<Character>() {

			public boolean test(Character c) {
				String str = "aeiou";
				if (str.contains(String.valueOf(c))) {
					return true;
				}
				return false;
			}

		}).toList();

		System.out.println("From a sentence, collect:Total number of vowels Total number of words");

		String sentence = "Java stream is powerful";

		String[] split = sentence.split(" ");

		String collect2 = Arrays.stream(split).collect(Collector.of(WordsCount::new, (wordCount, newWord) -> {

			wordCount.iWords++;

			long vowels = newWord.chars().mapToObj(c -> (char) c).filter(c -> "aeiou".contains(c.toString())).count();

			wordCount.iVowels += vowels;

		}, (wordCount1, wordCount2) -> {

			wordCount1.iWords += wordCount2.iWords;
			wordCount1.iVowels += wordCount2.iVowels;
			return wordCount1;
		},

				wordCount -> "Words:" + wordCount.iWords + " Vowels:" + wordCount.iVowels

		));

		
		System.out.println(collect2);
	}

}
