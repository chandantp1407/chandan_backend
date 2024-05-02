package day3;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortEmployeeById implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		
		return e1.getId()-e2.getId();
	}
	public static void main(String[] args) {
		List<Employee> employees=new LinkedList<Employee>();
		employees.add(new Employee(2,"varun",56.0));
		employees.add(new Employee(4,"Akash",78.0));
		employees.add(new Employee(1,"Mahesh",63.0));
		employees.add(new Employee(5,"Prajwal",35.0));
		Collections.sort(employees,(e1,e2) -> e1.getId()-e2.getId());
		for(Employee e:employees) {
			System.out.println(e);
		}
	}

}
