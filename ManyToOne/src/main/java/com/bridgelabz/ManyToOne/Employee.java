package com.bridgelabz.ManyToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee1")
public class Employee {
@Id
@GeneratedValue
private int id;
@Column(name="salary")
private int salary;
@Column(name="name")
private String name;
@Column(name="role")
private String role;
/*@ManyToOne
@JoinColumn(name="department_id")
private Department department;
public Department getDepartment() {
	return department;
}
public void setDepartment(Department department) {
	this.department = department;
}*/
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

}
