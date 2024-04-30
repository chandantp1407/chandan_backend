package Day2;

import java.util.Scanner;

public class Pattern20 {
	public static void main(String[] args) {
//
//        1 
//      1 2 3 
//    1 2 3 4 5 
//  1 2 3 4 5 6 7 
//1 2 3 4 5 6 7 8 9 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=n-i;j>=0;j--) {
				System.out.print("  ");
			}
			for(int k=1;k<=i*2-1;k++) {

				System.out.print(k+" ");
			}
			System.out.println();


		}
	}
}
