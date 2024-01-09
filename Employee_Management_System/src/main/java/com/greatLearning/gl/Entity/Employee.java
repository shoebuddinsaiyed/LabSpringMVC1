package com.greatLearning.gl.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Employee_first_name", nullable = false)
	private String first_Name;

	@Column(name = "Employee_last_name", nullable = false)
	private String last_Name;

	@Column(name = "Employee_email", nullable = false)
	private String Email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Employee(String first_Name, String last_Name, String email) {
		super();
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		Email = email;
	}

	public Employee() {

	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_Name=" + first_Name + ", last_Name=" + last_Name + ", Email=" + Email
				+ "]";
	}

}
