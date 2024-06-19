package com.super20.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.super20.DAO.CourseDao;
import com.super20.Entity.Course;

@Service
public class CourseService {
	
	@Autowired
	private CourseDao coursedao;
	
	
	public List<Course> getAllCourse(){
		List<Course> courses = coursedao.findAll();
		return courses;
		
	}
	
	public Course getCourseById(Long id) {
	Course course=	coursedao.getById(id);
		return course;
	}
	
	public Course saveCourse(Course course) {
		 
		return  coursedao.save(course);
	}
	
	public void deleteCourseById(Long id) {
		coursedao.deleteById(id);
	}
	
	public ResponseEntity<Course> updateCourse(Long id,Course course) {
		Optional<Course> courseOptional = Optional.of(this.getCourseById(id));
        if (courseOptional.isPresent()) {
            Course c1 = courseOptional.get();
            c1.setName(course.getName());
            return ResponseEntity.ok(this.saveCourse(c1));
        } else {
            return ResponseEntity.notFound().build();
        }
		
	}

}
