package com.bridgelabz.CRUD;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeDao {
	private static SessionFactory factory;

	static{
		Configuration configuration=new Configuration().configure();
		 factory=configuration.buildSessionFactory();
	}

	public static int addEmployee(){
		
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter employee name role and salary");
		String name=scanner.next();
		String role=scanner.next();
		int salary=scanner.nextInt();
		Employee employee=new Employee();
		employee.setName(name);
		employee.setRole(role);
		employee.setSalary(salary);
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		int id=(Integer) session.save(employee);
		System.out.println("before commit");
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
		System.out.println("Enter  employee name role and salary");
		String name=scanner.next();
		String role=scanner.next();
		int salary=scanner.nextInt();
		employee.setName(name);
		employee.setRole(role);
		employee.setSalary(salary);
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