package com.super20.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.super20.Entity.Course;
import com.super20.Service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseControlloer {
	
	@Autowired
	private CourseService service;
	
	@GetMapping
	public List<Course> getAllCourses() {
		return service.getAllCourse();
	}
	
	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable ("id") Long id) { 
		return service.getCourseById(id);
		
	}
	
	
	@PostMapping
	public Course addCourse(@RequestBody Course course) {
		return service.saveCourse(course);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable("id") Long id ) {
		service.deleteCourseById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable("id") Long id,  @RequestBody Course couse) {
		return service.updateCourse(id, couse);
	}

}
