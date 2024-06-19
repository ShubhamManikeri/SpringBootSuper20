package com.super20.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.super20.DAO.SubjectDao;
import com.super20.Entity.Subject;

import jakarta.transaction.Transactional;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectDao dao;
	
	public List<Subject> getAllSubjects(){
		return dao.getAllSubjects();
	}
	
	public Subject getSubjectById(Long id) {
		return dao.getSubjectById(id);
	}
	
	public void deleteSubjectById(@PathVariable Long id) {
	  dao.deleteSubject(id);;
	}
	
	
	 @Transactional
	public void saveSubject(Subject subject ) {
		dao.saveSubject(subject);
	} 
	
	
	
}
