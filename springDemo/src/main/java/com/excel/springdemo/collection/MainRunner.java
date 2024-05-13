package com.excel.springdemo.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRunner {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/excel/springdemo/collection/config.xml");
		Employee employee=(Employee) context.getBean("employee");
		System.out.println("Name: "+employee.getName());
		System.out.println("Phone: "+employee.getPhones());
		System.out.println("skills: "+employee.getSkills());
		System.out.println("Nominee "+employee.getNominees());
	}
}
