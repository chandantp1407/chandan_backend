package day4;

import java.util.HashSet;
import java.util.Scanner;

public class Student {
	int studentId;
	String studentName;
	int age;
	int marks;
	public Student(int studentId, String studentName, int age, int marks) {

		this.studentId = studentId;
		this.studentName = studentName;
		this.age = age;
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", age=" + age + ", marks=" + marks
				+ "]";
	}

	public int hashCode() {
		return this.age;

	}
	public boolean equals(Object obj) {
		Student stu=(Student) obj;
		return this.hashCode()==stu.hashCode()&&this.studentName==stu.studentName
				&&this.marks==stu.marks;
	}
	public static void main(String[] args) {
		HashSet<Student> students=new HashSet<Student>();
		while(true) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Student Id:");
			int studentId=sc.nextInt();
			System.out.println("Enter Student Name:");
			String studentName=sc.next();
			System.out.println("Enter Student age:");
			int age=sc.nextInt();
			System.out.println("Enter Student marks:");
			int marks=sc.nextInt();

			students.add(new Student(studentId, studentName, age, marks));
			System.out.println("want to add more students:");

			String value=sc.next();
			if(value.equalsIgnoreCase("no"))
				break;
		}
		for(Student stu:students) {
			System.out.println(stu);
		}
	}
}
