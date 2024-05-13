package com.excel.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("com/excel/springdemo/config.xml");
		Student student =(Student) context.getBean("student");
		System.out.println(student);
		Student student1 =(Student) context.getBean("student1");
		System.out.println(student1);
	}
}
