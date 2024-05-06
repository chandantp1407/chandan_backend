package day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import day4.Employee;

public class EmployeeMainClass {
	public static void main(String[] args) {
		HashMap<Integer, Employee1> emp=new HashMap<>();
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
			emp.put(empId,new Employee1(empId, empName, dept, designation));
			System.out.println("want to add more employees:");

			String value=sc.next();
			if(value.equalsIgnoreCase("no"))
				break;
		}
		Set<Integer> keys=emp.keySet();
//		ArrayList<Integer> sorted=new ArrayList<Integer>(emp.keySet());
//		Collections.sort(sorted);
		for(Integer emps:keys) {
			System.out.println(emps+"==>"+emp.get(emps));
		}
		
	}
}
