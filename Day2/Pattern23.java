package Day2;

import java.util.Scanner;

public class Pattern23 {
	public static void main(String[] args) {
		//	 *********
		//	  *******
		//	   *****
		//	    ***
		//	     *
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=sc.nextInt();
		for(int i=n;i>0;i--) {
			for(int j=n-i;j>=0;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=i*2-1;k++) {

				System.out.print("*");
			}
			System.out.println();
		}
	}
}
