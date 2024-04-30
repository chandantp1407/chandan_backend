package Demo;

import java.util.Scanner;

public class Arrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an array");
		int size = sc.nextInt();
		int[] numbers = new int[size];

		System.out.println("Enter the elements:");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();

		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);

		}
	}
}
