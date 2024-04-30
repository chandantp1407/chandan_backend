package Day2;

import java.util.Scanner;

public class Pattern18 {
	public static void main(String[] args) {
//		     1 
//		   0 0 0 
//		  1 1 1 1 1 
//		 0 0 0 0 0 0 0 
//		1 1 1 1 1 1 1 1 1 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=n-i;j>0;j--) {
				System.out.print("  ");
			}
			for(int k=1;k<=i*2-1;k++) {

				System.out.print(i%2+" ");
			}
			System.out.println();
		}

	}
}

