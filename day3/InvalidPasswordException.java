package day3;

import java.util.Scanner;

public class InvalidPasswordException extends Exception{

	private String message;
	public InvalidPasswordException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}

	public static void main(String[] args) {
		System.out.println("Enter the password");
		Scanner sc=new Scanner(System.in);
		int password=sc.nextInt();
		if(password==1234) {
			System.out.println("Valid Password");
		}
		else
			try {
				throw new InvalidPasswordException("invalid password");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

	}
}
