package day5;

import java.util.function.Predicate;

public class PredicateDemo {
	 public static void main(String[] args) 
	    { 
	        Predicate<Integer> greaterThanTen = (i) -> i > 10; 
	  
	       
	        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;  
	        boolean result = greaterThanTen.and(lowerThanTwenty).test(15); 
	        System.out.println(result); 
	  
	       
	        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15); 
	        System.out.println(result2); 
	        String input = "Hello, world!";

	        // Predicate to check if a string starts with 'H'
	        Predicate<String> startsWithH = str -> str.startsWith("H");

	        // Predicate to check if a string has length greater than 10
	        Predicate<String> isLongString = str -> str.length() > 10;

	        // Combining predicates using AND
	        Predicate<String> combinedPredicate = startsWithH.and(isLongString);

	        // Test the combined predicate
	        boolean result1 = combinedPredicate.test(input);
	        System.out.println("Starts with 'H' and has length > 10: " + result);
	    }
}
