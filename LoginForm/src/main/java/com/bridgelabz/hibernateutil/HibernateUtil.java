package com.bridgelabz.hibernateutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;

	static{
		Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
		 factory=configuration.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory(){
	
		return factory;
	}
}
