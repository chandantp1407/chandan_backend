package day5;

import java.util.function.Supplier;

public class SupplierDemo {
	public static void main(String args[]) 
    { 
		// Example 1: Using Supplier to provide a constant value
        Supplier<String> supplier1 = () -> "Hello, world!";
        System.out.println(supplier1.get()); // Output: Hello, world!
  
        // Example 2: Using Supplier to generate a random number
        Supplier<Double> randomValue = () -> Math.random(); 
 
        System.out.println(randomValue.get()); 
    } 
}
