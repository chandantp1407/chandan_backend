package com.excel.hibernateDemo.onetomany.entity;


import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student1")
public class Student1 {
	@Id
	@Column(name = "student_id")
	private int id;
	
	@Column(name="student_name")
	private String name;
	@Column(name = "student_age")
	private int age;
	@OneToMany(cascade =CascadeType.ALL,mappedBy = "student1")
	List<Laptop> laptops=new ArrayList<Laptop>();
}
