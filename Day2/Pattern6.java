package Day2;

import java.util.Scanner;

public class Pattern6 {
public static void main(String[] args) {
//	5 4 3 2 1
//	5 4 3 2 1
//	5 4 3 2 1
//	5 4 3 2 1
//	5 4 3 2 1
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the value of n:");
	int n=sc.nextInt();
	for(int i=0;i<n;i++) {
		for(int j=n;j>0;j--) {
			System.out.print(j+" ");
		}
		System.out.println();
	}
}
}
