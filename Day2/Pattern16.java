package Day2;

import java.util.Scanner;

public class Pattern16 {
	public static void main(String[] args) {
		//	1 1 1 1 1 
		//	2 2 2 2 
		//	3 3 3 
		//	4 4 
		//	5 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=i;j<=n;j++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
