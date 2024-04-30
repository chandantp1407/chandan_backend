package Demo;

public class SortingArray {
	public static void main(String[] args) {

		int [] numbers= {2,5,3,6,8,9};
		descendingSort(numbers);
		System.out.println("Array elements in descending order");
		for(int i=0;i<numbers.length;i++) {
			System.out.println(numbers[i]);
		}
		System.out.println("===============================");
		int [] numbers1= {2,5,3,6,8,9};
		ascendingSort(numbers);
		System.out.println("Array elements in ascending order");
		for(int i=0;i<numbers1.length;i++) {
			System.out.println(numbers1[i]);
		}
	}

	 static int[] ascendingSort(int[] numbers) {
			for(int i=0;i<numbers.length-1;i++) {
			
					if(numbers[i]<numbers[i+1]) {
						int temp=numbers[i+1];
						numbers[i+1]=numbers[i];
						numbers[i]=temp;
					}
			}
			return numbers;
	}

	static int[] descendingSort(int[] numbers) {

		for(int i=0;i<numbers.length;i++) {
			for(int j=0;j<numbers.length-1;j++) {
				if(numbers[i]>numbers[j+1]) {
					int temp=numbers[j];
					numbers[j]=numbers[i];
					numbers[i]=temp;
				}
			}

		}
		return numbers;
	}
}
