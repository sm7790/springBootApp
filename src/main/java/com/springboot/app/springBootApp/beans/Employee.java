package com.springboot.app.springBootApp.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "APP_EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_seq")
	@SequenceGenerator(
		    name="employee_seq",
		    sequenceName="APP_EMPLOYEE_SEQ",
		    allocationSize=20)
	@Column(name = "EMP_ID")
	private Long id;
	@Column(name = "EMP_FIRST_NAME")
	private String fastName;
	@Column(name = "EMP_LAST_NAME")
	private String lastName;
	@Column(name = "EMP_DEPT")
	private String dept;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFastName() {
		return fastName;
	}
	public void setFastName(String fastName) {
		this.fastName = fastName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	

}
