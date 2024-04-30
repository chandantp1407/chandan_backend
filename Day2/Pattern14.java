package Day2;

import java.util.Scanner;

public class Pattern14 {
	public static void main(String[] args) {
		//	5 
		//	5 4 
		//	5 4 3 
		//	5 4 3 2 
		//	5 4 3 2 1 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=n;j>=n-i;j--) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
