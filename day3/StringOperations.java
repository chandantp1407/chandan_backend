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
		//-------------Panagram-----------------------------------
		boolean rs1=isPanagram(str);
		if(rs1)
			System.out.println("String is a panagram");
		else
			System.out.println("String is not a panagram");
		//----------Anagram----------------------------------
		boolean rs2=isAnagram(str,str2);
		if(rs2)
			System.out.println("String is a anagram");
		else
			System.out.println("String is not a anagram");
		//-------------count characters----------
		countCharacters(str);

	}

	private static void countCharacters(String str) {
		int [] count=new int[26];
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(ch>='A'&& ch<='Z')
				count[ch-65]++;
			else if(ch>='a'&& ch<='z')
				count[ch-97]++;
		}
		for(int i=0;i<26;i++)
		{
			if(count[i]!=0)
				System.out.println((char)(i+65)+"---->"+count[i]);
		}
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
	private static boolean isPanagram(String str) {
		if(str.length()<26)
			return false;
		int [] count=new int [26];
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(ch>='A'&& ch<='Z')
				count[ch-65]++;
			else if(ch>='a'&& ch<='z')
				count[ch-97]++;
		}
		for(int i=0;i<26;i++) {
			if(count[i]==0)
				return false;
		}

		return true;

	}
	private static boolean isAnagram(String str1, String str2) {
		int [] c1=countFreq(str1);
		int [] c2=countFreq(str2);
		for(int i=0;i<26;i++)
		{
			if(c1[i]!=c2[i])
				return false;
		}
		return true;
	}

	private static int[] countFreq(String str) {
		int [] count=new int[26];
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(ch>='A'&& ch<='Z')
				count[ch-65]++;
			else if(ch>='a'&& ch<='z')
				count[ch-97]++;
		}
		return count;
	}
}
