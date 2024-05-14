package com.excel.spring_jdbc;

import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.excel.spring_jdbc.dao.StudentDao;
import com.excel.spring_jdbc.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
		StudentDao dao = context.getBean("studentDao",StudentDao.class);
		//				Student student=new Student();
		//				student.setId(3);
		//				student.setName("ullas");
		//				student.setCity("hassan");
		//				int rs=dao.insertStudent(student);
		//				System.out.println(rs);

		//		int rs=dao.updateStudent(new Student(2,"raju","mysore"));
		//		System.out.println(rs);

		//		Student s=new Student();
		//		s.setId(2);
		//		int del=dao.deleteStudent(s);
		//		System.out.println(del);
		List<Student> students=dao.selectAllStudent();
		for(Student s:students) {
			System.out.println(s);
		}
	}
}
