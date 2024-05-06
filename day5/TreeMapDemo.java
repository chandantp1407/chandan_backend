package day5;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String[] args) {
		//		Comparator<Integer> com=new Comparator<Integer>() {
		//
		//			@Override
		//			public int compare(Integer o1, Integer o2) {
		//
		//				return o1.compareTo(o2);
		//			}
		//		};
		//
		//		TreeMap<Integer, Employee1> tm=new TreeMap<Integer, Employee1>(com);
		//		while(true) {
		//			Scanner sc=new Scanner(System.in);
		//			System.out.println("Enter Employee Id:");
		//			int empId=sc.nextInt();
		//			System.out.println("Enter Employee Name:");
		//			String empName=sc.next();
		//			System.out.println("Enter Employee dept:");
		//			String dept=sc.next();
		//			System.out.println("Enter Employee designation:");
		//			String designation=sc.next();
		//			tm.put(empId,new Employee1(empId, empName, dept, designation));
		//			System.out.println("want to add more employees:");
		//
		//			String value=sc.next();
		//			if(value.equalsIgnoreCase("no"))
		//				break;
		//		}
		//		Set<Entry<Integer, Employee1>> emp=tm.entrySet();
		//		for(Entry<Integer, Employee1> emps:emp) {
		//			System.out.println(emps.getKey()+" ==>"+emps.getValue());
		//		}
//		Comparator<String> com=new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//
//				return o1.compareTo(o2);
//			}
//		};
//		TreeMap<String, Employee1> tm=new TreeMap<String, Employee1>((e1,e2) ->e1.compareTo(e2));
		TreeMap<String, Employee1> tm=new TreeMap<String, Employee1>(Comparable::compareTo);
		while(true) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Employee Id:");
			int empId=sc.nextInt();
			System.out.println("Enter Employee Name:");
			String empName=sc.next();
			System.out.println("Enter Employee dept:");
			String dept=sc.next();
			System.out.println("Enter Employee designation:");
			String designation=sc.next();
			tm.put(empName,new Employee1(empId, empName, dept, designation));
			System.out.println("want to add more employees:");

			String value=sc.next();
			if(value.equalsIgnoreCase("no"))
				break;
		}
		Set<Entry<String, Employee1>> emp=tm.entrySet();
		for(Entry<String, Employee1> emps:emp) {
			System.out.println(emps.getKey()+" ==>"+emps.getValue());
		}

	}
}
