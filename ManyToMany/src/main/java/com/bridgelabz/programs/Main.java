package com.bridgelabz.programs;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction = null;
		try {
			
			transaction = session.beginTransaction();

			Set<Course> courses = new HashSet<Course>();
			courses.add(new Course("Maths"));
			courses.add(new Course("Computer Science"));

			Student student1 = new Student("Ajay", courses);
			Student student2 = new Student("Rohit", courses);
			for(Course course:courses){
			session.save(course);
			}
			session.save(student1);
			session.save(student2);
			session.close();
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
