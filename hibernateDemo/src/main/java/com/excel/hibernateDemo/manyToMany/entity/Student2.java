package com.excel.hibernateDemo.manyToMany.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "student2")
public class Student2 {
	@Id
	@Column(name = "student_id")
	private int id;

	@Column(name="student_name")
	private String name;
	@Column(name = "student_age")
	private int age;
	@ManyToMany
	private List<Book> books=new ArrayList<Book>();
}
