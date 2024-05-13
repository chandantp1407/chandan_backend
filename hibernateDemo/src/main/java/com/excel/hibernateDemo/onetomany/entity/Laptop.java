package com.excel.hibernateDemo.onetomany.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "laptop")
public class Laptop {
	@Id
	@Column(name ="laptop_id")
	private int id;
	
	@Column(name = "laptop_brand")
	private String brand;
	
	@Column(name=" laptop_serialNo")
	private String serialNo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Student1 student1;

}
