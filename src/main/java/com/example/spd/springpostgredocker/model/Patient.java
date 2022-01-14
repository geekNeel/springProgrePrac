package com.example.spd.springpostgredocker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class Patient extends EntityAduit {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	public Patient() {
		super();
	}
	
	public Patient(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
