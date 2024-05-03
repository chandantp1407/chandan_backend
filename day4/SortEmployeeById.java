package day4;

import java.util.Scanner;
import java.util.TreeSet;

public class SortEmployeeById {
	public static void main(String[] args) {
		TreeSet<Employee> employees=new TreeSet<Employee>((e1,e2) ->e1.empId-e2.empId);
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
