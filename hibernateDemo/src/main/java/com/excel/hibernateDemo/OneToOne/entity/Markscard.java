package com.excel.hibernateDemo.OneToOne.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name = "marksCard")
public class Markscard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "marksCard_id")
	private int id;
	@Column(name = "marks_grade")
	private String grade;
	@Column(name = "marks")
	private double marks;
	@OneToOne(cascade = CascadeType.ALL)
	private Student student;

}
