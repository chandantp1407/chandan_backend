package Demo;

public class Patterns {
	public static void main(String[] args) {
		
//		1 1 1 1 1 
//		2 2 2 2 2 
//		3 3 3 3 3 
//		4 4 4 4 4 
//		5 5 5 5 5 
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		System.out.println("=======================");
//		1 
//		2 3 
//		3 4 5 
//		4 5 6 7 
//		5 6 7 8 9 
		int n=5;
		for(int i=1;i<=n;i++) {
			int k=i;
			for(int j=1;j<=i;j++) {
				System.out.print(k++ +" ");
			}
			System.out.println();
		}
	}
}
