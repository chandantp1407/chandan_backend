package day3;

public class Demo2 {
	public static void main(String[] args) {
		String s=null;
		try {
			System.out.println(s.lastIndexOf(5));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	

	}
}
