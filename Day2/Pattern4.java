package Day2;

import java.util.Scanner;

public class Pattern4 {
public static void main(String[] args) {
//	A B C D E 
//	A B C D E 
//	A B C D E 
//	A B C D E 
//	A B C D E 

	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the value of n:");
	int n=sc.nextInt();
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			System.out.print((char)(j+65)+" ");
		}
		System.out.println();
	}
}
}
