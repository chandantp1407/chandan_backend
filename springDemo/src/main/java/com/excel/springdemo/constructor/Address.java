package com.excel.springdemo.constructor;

public class Address {
	private int id;
	
	private String place;

	@Override
	public String toString() {
		return "Address [id=" + id + ", place=" + place + "]";
	}

	public Address(int id, String place) {
		super();
		this.id = id;
		this.place = place;
	}
	
}
