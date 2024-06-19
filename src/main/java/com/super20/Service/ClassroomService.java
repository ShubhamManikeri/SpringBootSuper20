package com.super20.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.super20.DAO.ClassroomDao;
import com.super20.Entity.Classroom;

@Service
public class ClassroomService {
	
	 @Autowired
	    private ClassroomDao classroomRepository;

	    public List<Classroom> getAllClassrooms() {
	        return classroomRepository.findAll();
	    }

	    public Optional<Classroom> getClassroomById(Long id) {
	        return classroomRepository.findById(id);
	    }

	    public Classroom saveClassroom(Classroom classroom) {
	        return classroomRepository.save(classroom);
	    }

	    public void deleteClassroom(Long id) {
	        classroomRepository.deleteById(id);
	    }

}
