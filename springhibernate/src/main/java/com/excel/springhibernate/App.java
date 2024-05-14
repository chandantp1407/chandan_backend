package com.excel.springhibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
	public static void main( String[] args )
	{
		ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
		StudentDao dao  = context.getBean("studentDao",StudentDao.class);

		Student s=new Student();
		s.setId(1002);
		s.setName("varun");
		s.setMarks(87);
//						int res=dao.insertStudent(s);
//						System.out.println(res);

			
				Student update=dao.updateStudent(s);
				System.out.println(update);

		//		Student st=dao.getStudent(1003);
		//		System.out.println(st);
//		Student stu	=dao.deleteStudent(1003);
//		System.out.println(stu);
//		List<Student> students=dao.selectAllStudents();
//		for(Student s1:students) {
//			System.out.println(s1);
		}
	}

