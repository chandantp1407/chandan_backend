package day4;

import java.util.HashSet;
import java.util.Scanner;

public class Employee {
	Integer empId;
	String empName;
	Double empSal;
	public Employee(int empId, String empName, double empSal) {

		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
	}
	@Override
	public String toString() {
		return empId+" "+empName+" "+empSal;
	}
	@Override
	public int hashCode() {
		return empId;

	}
	@Override
	public boolean equals(Object o) {
		Employee emp=(Employee) o;
		return this.hashCode()==emp.hashCode();

	}
	public static void main(String[] args) {
		HashSet<Employee> employees=new HashSet<Employee>();
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
