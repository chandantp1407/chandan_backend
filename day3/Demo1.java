package day3;

public class Demo1 {
	public static void main(String[] args) {
		try {
			System.out.println(10/0);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		System.out.println("rest of the code");
	}
}
