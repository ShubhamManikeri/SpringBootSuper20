package com.super20.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.super20.Entity.Faculty;

@Repository
public class FacultyDao {

	@Autowired
	SessionFactory sf;
	
	public Faculty addFaculty(Faculty faculty)
	{
		Session session = sf.openSession();
		session.save(faculty);
		session.beginTransaction().commit();
		return faculty;
	}
	
	public List<Faculty> getAllFaculty()
	{
		Session session = sf.openSession();
		List<Faculty> list = session.createQuery("from Faculty", Faculty.class).list();
		return list;
	}
	
	public Faculty getFacultyById(Long id)
	{
		Session session = sf.openSession();
		Faculty faculty = session.get(Faculty.class, id);
		session.save(faculty);
		session.beginTransaction().commit();
		return faculty;
	}
	
	public Faculty updateFaculty(Faculty faculty)
	{
		Session session = sf.openSession();
		session.update(faculty);
		session.beginTransaction().commit();
		return faculty;
	}
	
	public void deleteFaculty(Long id)
	{
		Session session = sf.openSession();
		Faculty faculty = session.get(Faculty.class, id);
		session.delete(faculty);
		session.beginTransaction().commit();
	}
}
