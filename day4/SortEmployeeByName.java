package day4;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class SortEmployeeByName {
	public static void main(String[] args) {
		Comparator<Employee> com=new Comparator<Employee>() {
			
			@Override
			public int compare(Employee e1, Employee e2) {
				
				return e1.empName.compareTo(e2.empName);
			}
		};
		
		
		TreeSet<Employee> employees=new TreeSet<Employee>(com);
		while(true) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Employee Id:");
			int empId=sc.nextInt();
			System.out.println("Enter Employee Name:");
			String empName=sc.next();
			System.out.println("Enter Employee sal:");
			Double empSal=sc.nextDouble();
			employees.add(new Employee(empId, empName, empSal));
			System.out.println("want to add more employees:");

			String value=sc.next();
			if(value.equalsIgnoreCase("no"))
				break;
		}
		for(Employee emp:employees) {
			System.out.println(emp);
		}
	}
}
