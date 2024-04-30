package Day2;

import java.util.Scanner;

public class Pattern9 {
	public static void main(String[] args) {
//		1 2 3 4 5 
//		1 2 3 4 
//		1 2 3 
//		1 2 
//		1
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
