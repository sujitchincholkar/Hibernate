package com.bridgelabz.ManyToOne;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Department")
public class Department {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="department")
	private String department;
	@OneToMany
	@JoinColumn(name="department_id")
	private Set<Employee> employees;
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employee) {
		this.employees = employee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
