package Day2;

import java.util.Scanner;

public class Pattern19 {
	public static void main(String[] args) {

		//		        1 
		//		      1 0 1 
		//		    1 0 1 0 1 
		//		  1 0 1 0 1 0 1 
		//		1 0 1 0 1 0 1 0 1 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=n-i-1;j>=0;j--) {
				System.out.print("  ");
			}
			for(int j=1;j<=i*2-1;j++) {

				System.out.print(j%2+" ");
			}
			System.out.println();


		}
	}
}
