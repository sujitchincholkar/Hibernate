package com.bridgelabz.OneToOne;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeDao {
	private static SessionFactory factory;

	static{
		Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
		 factory=configuration.buildSessionFactory();
	}
	private static SessionFactory getSessionFactory(){
	
		return factory;
	}
	public static int addEmployee(){
		Scanner scanner =new Scanner(System.in);
		Department department=new Department();
		department.setDepartment("HR");
		//Set<Employee> employees=new HashSet<>();
		
		System.out.println("Enter employee name role and salary");
		String name=scanner.next();
		String role=scanner.next();
		int salary=scanner.nextInt();
		Employee employee=new Employee();
		employee.setName(name);
		employee.setRole(role);
		employee.setSalary(salary);
		//employees.add(employee);
		employee.setDepartment(department);
	
		System.out.println("Enter employee name role and salary");
		String name1=scanner.next();
		String role1=scanner.next();
		int salary1=scanner.nextInt();
		Employee employee1=new Employee();
		employee1.setName(name1);
		employee1.setRole(role1);
		employee1.setSalary(salary1);
		employee1.setDepartment(department);
       // employees.add(employee1);
	//	department.setEmployees(employees);
        
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(department);
		int id=(Integer) session.save(employee);
		int id1=(Integer) session.save(employee1);
		System.out.println(id1);
		transaction.commit();
		session.close();
		
		return id;
		
	}
	public static void display(){
		
		Session session=factory.openSession();
		List<Employee> employees=session.createQuery("From Employee").list();
		
		for(int i=0;i<employees.size();i++){
			Employee employee=employees.get(i);
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getRole());
			System.out.println(employee.getSalary());
			System.out.println(employee.getSalary());
			//System.out.println(employee.getDepartment().getDepartment());
			System.out.println("===================");
		}
		session.close();
	
		
	}
	public static void updateEmployee(){
		
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		display();
		System.out.println("Enter id to Update record");
		Scanner scanner =new Scanner(System.in);
		int id=scanner.nextInt();
		Employee employee=session.get(Employee.class, id);
		System.out.println("Enter  employee name role and salary and department");
		String name=scanner.next();
		String role=scanner.next();
		String department=scanner.next();
		int salary=scanner.nextInt();
		employee.setName(name);
		employee.setRole(role);
		employee.setSalary(salary);
		//employee.getDepartment().setDepartment(department);
		session.update(employee);
		transaction.commit();
		session.close();
		
	}
	public static void deleteEmployee(){
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		display();
		System.out.println("Enter id to delete record");
		Scanner scanner =new Scanner(System.in);
		int id=scanner.nextInt();
		Employee employee=session.get(Employee.class, id);
		session.delete(employee);
		transaction.commit();
		session.close();
	}
}