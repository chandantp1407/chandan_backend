package day3;

public class StringOperations {
	public static void main(String[] args) {
		String str="malayalam";
		String str2="String is immutable";
		//		boolean rs=isPalindrome(str);
		System.out.println(isPalindrome(str));
		//		if(rs==true) {
		//			System.out.println("String is palindrome");
		//		}
		//		else
		//			System.out.println("string is not a palindrome");
		String rev=reverse(str);
		System.out.println(rev);
		//---------------count words----------------------------
		int count=countWords(str2);
		 System.out.println("Number of words in a string is " + count);
		 
		//-----------------count Vowels-----------------------------
		int vowels=countVowels(str);
		System.out.println(vowels);
		
		//------------------isAllVowels-----------------------------		
		boolean rs=	isAllVowels(str);
		if(rs==true) {
			System.out.println("String contains all vowels");
		}
		else
			System.out.println("String is not contains all vowels");
	}

	private static int countWords(String str2) {

		int count = 1;
		for (int i = 0; i < str2.length() - 1; i++)
		{
			if ((str2.charAt(i) == ' ') && (str2.charAt(i + 1) != ' '))
			{
				count++;
			}
		}
		return count;
	}

	private static boolean isAllVowels(String str) {
		str = str.toLowerCase(); 
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
				return false; 
			}
		}
		return true;
	}

	private static int countVowels(String str) {
		str = str.toLowerCase(); 
		int count =0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				count++;
			}
		}
		return count;
	}

	private static String reverse(String str) {
		char[] ch=str.toCharArray();
		String rev=" ";
		for(int i=ch.length-1;i>=0;i--) {
			rev=rev+ch[i];
		}
		return rev;
	}

	private static boolean isPalindrome(String str) {
		String rev=reverse(str);
		return str.equals(rev);
	}
}
