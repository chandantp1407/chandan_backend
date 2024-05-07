package day6;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Java8Problems {
	public static void main(String[] args) {
		List<Integer> asList=Arrays.asList(1,2,4,5,5,8,3,167,45);
		//		//Printing even numbers
		//		asList.stream().filter(e ->e%2==0).forEach(System.out::println);
		//		//adding even numbers to list
		//		List<Integer>collect=asList.stream().filter(e ->e%2==0).collect(Collectors.toList());
		//		System.out.println(collect);
		//		//Numbers start with 1
		//		asList.stream().map(e ->Integer.toString(e))
		//		.filter(e ->e.startsWith("1")).forEach(System.out::println);
		//
		//		// duplicate elements in the list
		//		Set<Integer> set=new HashSet<Integer>();
		//		asList.stream().filter(e ->!set.add(e)).forEach(System.out::println);
		//		//find first element in the list
		//		Integer orElse	=asList.stream().findFirst().orElse(0);
		//		System.out.println(orElse);
		//
		//		//Total elements in the list
		//		System.out.println(asList.stream().count());
		//
		//		//Total Distinct elements in the list
		//		System.out.println(asList.stream().distinct().count());
		//
		//		//Maximum element in the list
		//		Integer integer	=asList.stream().max((e1,e2) ->e1.compareTo(e2)).get();
		//		System.out.println(integer);

		//First non repeated character
		String input="Java articles are Awesome";

		//		Character character=input.chars().mapToObj(c ->(char)c).filter(e ->input.indexOf(e)==input.indexOf(e))
		//				.findFirst().get();
		//		System.out.println(character);

		//First  repeated character
		//		Character chars=input.chars().mapToObj(c ->(char)c).filter(e ->input.indexOf(e)!=input.indexOf(e))
		//				.findFirst().get();
		//		System.out.println(chars);

		//sort all elements present in a list
		//		asList.stream().sorted().forEach(System.out::println);

		//sort all elements in reverse order

		//		asList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

		//		int size=asList.stream().sorted().distinct().collect(Collectors.toList()).size();
		//		System.out.println(size!=asList.size());

		//Make a cube of number and check whether it is greater than 150 
		//		asList.stream().map(e ->e*e*e).filter(e ->e>150).forEach(System.out::println);
		//Frequency of each character
		//		String input1="asddjklasdjklk";
		//
		//		Map<Character, Long> collect=input1.chars().mapToObj(c->(char)c).collect(Collectors
		//				.groupingBy(Function.identity(), Collectors.counting()));
		//		System.out.println(collect);
		//
		//		List<String> names=Arrays.asList("AA","BB","AA","CC");
		//		names.stream().filter(e ->Collections.frequency(names, e)>1)
		//		.collect(Collectors.groupingByConcurrent(Function.identity(),Collectors.counting()))
		//		.forEach((str,count)->System.out.println(str+"=>"+count));

		//Seperate odd and even numbers
		//		Map<Boolean, List<Integer>> lists=asList.stream().collect(Collectors.partitioningBy(i->i%2==0));
		//		System.out.println(lists);

		//Reverse order of list
		//		asList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		//print multiple of 5 from the list

		//		asList.stream().filter(i->i%5==0).forEach(System.out::println);

		//Merge two unsorted array into single sorted array
		Integer [] a= {1,3,5,5,3,9};
		Integer []b= {2,4,5,6,8,10};
		//		IntStream.concat(Arrays.stream(a),Arrays.stream(b)).sorted().forEach(System.out::println);
		//Merge two unsorted array into single sorted array without duplicates
		//		IntStream.concat(Arrays.stream(a),Arrays.stream(b)).sorted().distinct().forEach(System.out::print);
		//Three max and three min elements from the list
		//		asList.stream().sorted().limit(3).forEach(System.out::println);
		//		asList.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);

		//Sum of all the elements in the array
		//		Integer sum=Arrays.stream(a).sum();
		//		System.out.println(sum);

		//Average of all the elements in the array
		//		Double avg=	Arrays.stream(a).average().getAsDouble();
		//		System.out.println(avg);
		//		
		//sort list of strings in increasing order of their length
		List<String> names=Arrays.asList("1AA","2AA","CATS","DATSHK");
		//		names.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
		//
		//		//sort list of strings in increasing order of their length
		//		names.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);

		//Reverse an Integer Array
		//		IntStream.rangeClosed(1, a.length).map(i->a[a.length-i]).forEach(System.out::println);

		//String Palindrome check
		//		String str="malayalam";
		//		boolean res	=IntStream.range(0, str.length()/2).noneMatch(i->str.charAt(i)!=str.charAt(str.length()-i-1));
		//		System.out.println(res);

		//Last Element of an array
		//		String last=names.stream().skip(names.size()-1).findFirst().get();
		//		System.out.println(last);

		//check person age in years
		//		LocalDate birthday=LocalDate.of(2001, 7, 14);
		//		LocalDate today=LocalDate.now();
		//		System.out.println(ChronoUnit.YEARS.between(birthday, today));

		//Remove Duplicates from list
		//		List<String> dup=names.stream().distinct().collect(Collectors.toList());
		//		System.out.println(dup);

		//Frequency of each array element
		//		Map<Integer, Long> freq=asList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		//		System.out.println(freq);

		//Max and min element in the list
		//		Integer max=asList.stream().max(Comparator.naturalOrder()).get();
		//		System.out.println(max);
		//		Integer min=asList.stream().min(Comparator.naturalOrder()).get();
		//		System.out.println(min);

		//Joining list of strings with prefix ,suffix,Delimeter
		//		String pre=names.stream().collect(Collectors.joining(",","prefix "," suffix"));
		//		System.out.println(pre);


		//Second largest element in an array

		//		Integer second=	asList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		//		System.out.println(second);

		//common elements between two array
		//		List<Integer> list1	=Arrays.asList(1,3,5,7,9);
		//		List<Integer> list2	=Arrays.asList(2,4,5,6,8,10);
		//		list1.stream().filter(list2::contains).forEach(System.out::println);
		//
		//		//sum of first 10 natural numbers
		//		Integer sum	=IntStream.range(1, 11).sum();
		//		System.out.println(sum);

		// find String starts with number
		//		names.stream().filter(str->Character.isDigit(str.charAt(0))).forEach(System.out::println);

//		String input1="Java articles are Awesome";
//		String words=Arrays.stream(input1.split(" ")).map(word->new StringBuffer(word).reverse())
//				.collect(Collectors.joining(" "));
//		System.out.println(words);
//
//
//		//sum of all digits of a number
//		Integer num=123;
//		Integer num2=Stream.of(String.valueOf(num).split("")).collect(Collectors.summingInt(Integer::parseInt));
//
//		System.out.println(num2);
		
		/*Anagram string*/
		String str1 = "care";
		String str2 = "race";
		
		str1 = Stream.of(str1.split("")).map(String :: toUpperCase).sorted().collect(Collectors.joining());
		String collect2 = Stream.of(str2.split("")).map(String :: toUpperCase).sorted().collect(Collectors.joining());
		
		Boolean option=Optional.ofNullable(str1).map(e ->e.equals(collect2)).get();
		System.out.println(option);

		/*Fiboonacci Series*/
		System.out.println();
		Stream.iterate(new int[] {0,1}, f -> new int[] {f[1], f[0] + f[1] }).limit(10)
		.map(f -> f[0]).forEach(i -> System.out.print(i+" "));



	}
}
