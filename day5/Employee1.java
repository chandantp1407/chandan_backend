package day5;

public class Employee1 {
	Integer id;
	String name;
	String dept;
	String designation;
	public Employee1(int id, String name, String dept, String designation) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", dept=" + dept + ", designation=" + designation + "]";
	}

}
