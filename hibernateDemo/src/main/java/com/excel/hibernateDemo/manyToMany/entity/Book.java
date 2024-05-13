package com.excel.hibernateDemo.manyToMany.entity;

import java.util.ArrayList;
import java.util.List;

import com.excel.hibernateDemo.onetomany.entity.Student1;

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
@Table(name = "book")
public class Book {
	@Id
	@Column(name = "book_id")
	private int id;
	@Column(name="book_name")
	private String name;
	@ManyToMany
	private List<Student2> students=new ArrayList<Student2>();

}
