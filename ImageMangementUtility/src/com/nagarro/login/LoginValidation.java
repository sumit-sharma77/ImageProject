package com.nagarro.login;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nagarro.entities.users;

public class LoginValidation {
	private SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(users.class)
			.buildSessionFactory();

	/**
	 * To get username and password to compare with database.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean validateLogin(String username, String password) {
		boolean retVal = false;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query<users> query = session.createQuery("from users where username=:user");
		query.setParameter("user", username);
		
		List<users> matchedUser = query.list();
		if(matchedUser.size() > 0) {
			if(matchedUser.get(0).getPasword().equals(password)) {
				retVal = true;
			}
		}
		
		return retVal;
	}


}
