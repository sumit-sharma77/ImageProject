package com.nagarro.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nagarro.entities.Image;

public class ImageDAO {
	private SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Image.class)
			.buildSessionFactory();
	
	public void insertImage(Image img) {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(img);
		session.getTransaction().commit();
	}
	
	public List<Image> getImages(String username){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query<Image> query = session.createQuery("FROM Image where username=:usr");
		query.setParameter("usr", username);
		return query.list();
	}

	public void deleteImage(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query<Image> query = session.createQuery("delete from Image where imageId=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		session.getTransaction().commit();
		
	}

	public void editName(int id, String newName) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query<Image> query = session.createQuery("update Image set imageName=:name where imageId=:id");
		query.setParameter("name", newName);
		query.setParameter("id", id);
		query.executeUpdate();
		session.getTransaction().commit();
		
	}

}
