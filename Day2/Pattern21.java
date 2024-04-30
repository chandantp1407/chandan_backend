package Day2;

import java.util.Scanner;

public class Pattern21 {
	public static void main(String[] args) {
		//		      1 
		//	        0 1 0 
		//	      1 0 1 0 1 
		//	    0 1 0 1 0 1 0 
		//	  1 0 1 0 1 0 1 0 1 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=sc.nextInt();
		int i,j,k;
		int x=1;
		for( i=1;i<=n;i++) {
			for( j=n-i;j>=0;j--) {
				System.out.print("  ");
			}
			for( k=1;k<=i*2-1;k++) {
				System.out.print(x%2+" ");
				x++;
			}

			System.out.println();



		}
	}
}

