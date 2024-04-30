package Day2;

import java.util.Scanner;

public class Pattern5 {
public static void main(String[] args) {
//	a a a a a 
//	b b b b b 
//	c c c c c 
//	d d d d d 
//	e e e e e 
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the value of n:");
	int n=sc.nextInt();
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			System.out.print((char)(i+97)+" ");
		}
		System.out.println();
	}
}
}
