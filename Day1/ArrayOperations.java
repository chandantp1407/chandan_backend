package Demo;

import java.util.Scanner;

public class ArrayOperations {
	public static void main(String[] args) {
		int[] arr=createArray();
		System.out.println("==========================================");

		printArray(arr);
		System.out.println("===========================================");

		//		int [] rev=reverseArray(arr);
		//		for (int i = 0; i < rev.length; i++) {
		//			System.out.println(rev[i]);
		//		}
		//		System.out.println("===========================================");
		//
		//		int []sort=sortArray(arr);
		//		for (int i = 0; i < sort.length; i++) {
		//			System.out.println(sort[i]);
		//		}
		//		System.out.println("=========================================");
		//		int [] merge=mergeArray(arr);
		//
		//		for(int i=0;i<merge.length;i++) {
		//			System.out.println(merge[i]);
		//		}
		//		System.out.println("================================================");
		//		int[] b=createArray();
		//		System.out.println("Second array is:");
		//		for(int i=0;i<b.length;i++) {
		//			System.out.println(b[i]+" ");
		//		}
		//		System.out.println("=================================================");
		//		int [] zigzag=zigZagMergeArray(arr,b);
		//		for(int i=0;i<zigzag.length;i++) {
		//			System.out.println(zigzag[i]+" ");
		//		}
		//		System.out.println("=================================================");

		//	int max	=maxElement(arr);
		//	System.out.println("Maximum element is:"+max);
		//	int min	=minElement(arr);
		//	System.out.println("Minimum element is:"+min);
		//	
		//		System.out.println("================================================");
		//		int[] b1=createArray();
		//		System.out.println("Second array is:");
		//		for(int i=0;i<b1.length;i++) {
		//			System.out.println(b1[i]+" ");
		//		}
		//		System.out.println("=================================================");
		//		int [] union=unionOfArrays(arr,b1);
		//		for(int values:union){
		//			if(values!=0)
		//			System.out.println(values);
		//		}
		System.out.println("===================================================");
		int[] b2=createArray();
		System.out.println("Second array is:");
		for(int i=0;i<b2.length;i++) {
			System.out.println(b2[i]+" ");
		}
		System.out.println("=================================================");
		int [] inter=intersectionOfArrays(arr,b2);
		for(int values:inter){
			if(values!=0)
				System.out.println(values);
		}
		int[] br=removeDuplicate(arr);
		for(int i=0;i<br.length;i++)
		{
			System.out.println(br[i]+" ");
		}
		System.out.println("====================================================");
		int rs=occuranceofArrEle(arr,5);
		System.out.println("The element present "+rs+" times");

		System.out.println("============================================================");
		int pc=countPrimeNumber(arr);
		System.out.println("Number of Prime numbers:"+pc);
		System.out.println("================================================================");
		int[] rem=duplicateElements(arr);
		for(int i=0;i<rem.length;i++)
		{
			System.out.println(rem[i]+" ");
		}
	}

	private static int[] duplicateElements(int[] arr) {
		int[] c=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==arr[i+1]) {
				c[i]=arr[i];
			}
		}
		return c;
	}

	private static int countPrimeNumber(int[] x) {
		int count=0;
		for(int i=0;i<x.length;i++) {
			boolean rs=isPrime(x[i]);
			if(rs)
				count++;
		}
		return count;
	}

	static boolean isPrime(int n) {
		for(int i=2;i<=n/2;i++) {
			if(n%2==0)
				return false;
		}
		return true;

	}

	private static int occuranceofArrEle(int[] x, int ele) {
		int count=0;
		for(int i=0;i<x.length;i++) {

			if(x[i]==ele)
			{
				count++;

			}
		}
		return count;	

	}

	private static int[] removeDuplicate(int[] arr) {
		int [] br=new int[arr.length];
		int k=0;
		for(int i=0;i<arr.length;i++) {
			boolean rs=true;
			for(int j=0;j<k;j++)
			{
				if(arr[i]==br[j]) {
					rs=false;
					break;
				}
			}
			if(rs)
				br[k++]=arr[i];
		}
		int[] rs=new int[k];
		for(int i=0;i<rs.length;i++) {
			rs[i]=br[i];
		}
		return rs;

	}


	private static int[] intersectionOfArrays(int[] a, int[] b) {
		int [] c=new int[a.length+b.length];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
				if(a[i]==b[j]) {
					c[j++]=a[i];
				}
			}
		}
		return c;
	}


	static int[] unionOfArrays(int[] a, int[] b) {
		int [] newArr=new int[a.length+b.length];

		int i=0,j=0,k=0;
		while(i<a.length&&j<b.length) {
			if(a[i]==b[j]) {
				newArr[k++]=a[i++];
				j++;
			}
			else if(a[i]<b[j]) {
				newArr[k++]=a[i++];
			}
			else {
				newArr[k++]=b[j++];
			}
		}
		while(i<a.length) {
			newArr[k++]=a[i++];
		}
		while(j<b.length) {
			newArr[k++]=b[j++];
		}

		return newArr;
	}


	static int[] createArray() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an array");
		int size = sc.nextInt();
		int[] numbers = new int[size];

		System.out.println("Enter the elements:");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();

		}
		return numbers;

	}

	static void printArray(int[] arr) {
		System.out.println("First array is:");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}


	static int[] reverseArray(int[] arr) {
		for(int i=arr.length-1;i>=0;i--) {
			System.out.println(arr[i]);
		}
		return arr;

	}
	static int[] sortArray(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {

			if(arr[i]<arr[i+1]) {
				int temp=arr[i+1];
				arr[i+1]=arr[i];
				arr[i]=temp;
			}
		}
		return arr;

	}
	static int[] mergeArray(int[] a) {
		System.out.println("First array is:");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]+" ");
		}
		int [] b=createArray();
		System.out.println("Second array is:");
		for(int i=0;i<b.length;i++) {
			System.out.println(b[i]+" ");
		}
		System.out.println("=============================================");
		int [] c=new int[a.length+b.length];
		for(int i=0;i<a.length;i++) {
			c[i]=a[i];
		}
		for(int i=0;i<b.length;i++) {
			c[a.length+i]=b[i];
		}
		return c;

	}
	static int[] zigZagMergeArray(int[] a, int[] b) {
		int [] c=new int[a.length+b.length];
		int res=0;
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			c[res++] = a[i++];
			c[res++] = b[j++];
		}
		while (i < a.length) {
			c[res++] = a[i++];
		}
		while (j < b.length) {
			c[res++] = b[j++];
		}
		return c;
	}
	static int maxElement(int[] arr) {
		int max=arr[0];
		for (int i = 0; i < arr.length; i++) {

			if(arr[i]>max) {
				max=arr[i];
			}
		}
		return max;

	}
	private static int minElement(int[] arr) {
		int min=arr[0];
		for (int i = 0; i < arr.length; i++) {

			if(arr[i]<min) {
				min=arr[i];
			}
		}
		return min;

	}
}
