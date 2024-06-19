package com.super20.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.super20.Entity.Department;

@Repository
public class DepartmentDao {
	
	@Autowired
	SessionFactory sf;
	
	public Department addDepartment(Department department)
	{
		Session session = sf.openSession();
		session.save(department);
		session.beginTransaction().commit();
		return department;
	}
	
	public List<Department> getAllDepartment()
	{
		Session session = sf.openSession();
		List<Department> department = session.createQuery("from Department", Department.class).list();
		return department;
	}
	
	public Department getDepartmentById(Long dept_id)
	{
		Session session = sf.openSession();
		Department department = session.get(Department.class, dept_id);
		session.save(department);
		session.beginTransaction().commit();
		return department;
	}
	
	public Department updateDepartment(Department department)
	{
		Session session = sf.openSession();
		session.update(department);
		session.beginTransaction().commit();
		return department;
	}
	
	public void deleteDepartment(Long dept_id)
	{
		Session session = sf.openSession();
		Department department = session.get(Department.class, dept_id);
		session.delete(department);
		session.beginTransaction().commit();	
		
	}

}
