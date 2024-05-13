package com.excel.springdemo.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainRunner {
	public static void main(String[] args) {

		ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
		Student student=context.getBean("student",Student.class);
		System.out.println(student);
		student.study();
	}
}

