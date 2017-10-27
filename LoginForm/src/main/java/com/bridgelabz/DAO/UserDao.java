package com.bridgelabz.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bridgelabz.controller.LoginController;
import com.bridgelabz.hibernateutil.HibernateUtil;
import com.bridgelabz.model.User;

public class UserDao {
	static  Logger logger=Logger.getLogger(UserDao.class);
	public static User isExist(String email) {
		User user=null;
		try {
			SessionFactory factory=HibernateUtil.getSessionFactory();
			Session session=factory.openSession();
			TypedQuery<User> query=session.createQuery("From User where email=:email");
			query.setParameter("email",email);
			List<User> list=query.getResultList();
			if(!list.isEmpty())
			user=list.get(0);
			session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			logger.error("user retreive failed");
			e.printStackTrace();
		}
			return user;
	}

	public static User getUser(String email,String password) {
		User user=null;
		try {
			SessionFactory factory=HibernateUtil.getSessionFactory();
			Session session=factory.openSession();
			TypedQuery<User> query=session.createQuery("From User where email=:email "
					+ "and password=:password");
			query.setParameter("email",email);
			query.setParameter("password",password);
			List<User> list=query.getResultList();
			if(!list.isEmpty())
			user=list.get(0);
			session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			logger.error("user retreive failed");
			e.printStackTrace();
		}
			return user;
	}
	public static int insertUser(User user){
		int id=0;
		try {
			SessionFactory factory=HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			id = (int) session.save(user);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("insert unsuccessful");
			e.printStackTrace();
		}
		return id;
	}
	/*public static void updateUser(User user){	
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
			session.update(user);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}

	}*/

}
