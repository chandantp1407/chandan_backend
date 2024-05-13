package com.excel.springdemo.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.excel.springdemo.javaconfig")
public class JavaConfig {
	@Bean
	public Student getStudent() {
		return new Student();

	}
	@Bean
	public Samosa getSamosa() {
		return new Samosa();

	}
}
