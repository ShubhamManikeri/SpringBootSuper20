package com.super20.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.super20.DAO.FacultyDao;
import com.super20.Entity.Faculty;

@Service
public class FacultyService {

	@Autowired
	FacultyDao dao;
	
	public Faculty addFaculty(Faculty faculty)
	{
		return dao.addFaculty(faculty); 
	}
	
	public List<Faculty> getAllFaculty()
	{
		return dao.getAllFaculty();
	}
	
	public Faculty getFacultyById(Long id)
	{
		return dao.getFacultyById(id);
	}
	
	public Faculty updateFaculty(Faculty faculty)
	{
		return dao.updateFaculty(faculty);
	}
	
	public void deleteFacultyById(Long id)
	{
		dao.deleteFaculty(id);
	}

}
