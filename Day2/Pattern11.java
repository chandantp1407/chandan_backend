package Day2;

import java.util.Scanner;

public class Pattern11 {
//	5 5 5 5 5 
//	4 4 4 4 
//	3 3 3 
//	2 2 
//	1 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=sc.nextInt();
		for(int i=n;i>0;i--) {
			for(int j=i;j>0;j--) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
