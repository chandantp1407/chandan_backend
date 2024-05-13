package com.excel.springdemo.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Autowired
	private Samosa samosa;

	public Samosa getSamosa() {
		return samosa;
	}

	public void setSamosa(Samosa samosa) {
		this.samosa = samosa;
	}
	public void study() {
		this.samosa.displayPrice();
		System.out.println("student is studying");
	}

	@Override
	public String toString() {
		return "Student [samosa=" + samosa + "]";
	}
	
}
