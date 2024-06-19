package com.super20.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.super20.Entity.Subject;
import com.super20.Service.SubjectService;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
	
	 @Autowired
	    private SubjectService subjectService;

	    @GetMapping
	    public List<Subject> getAllSubjects() {
	        return subjectService.getAllSubjects();
	    }

	    @GetMapping("/{id}")
	    public Subject getSubjectById(@PathVariable Long id) {
	        return subjectService.getSubjectById(id);
	    }

	    @PostMapping
	    public Subject createSubject(@RequestBody Subject subject) {
	        subjectService.saveSubject(subject);
	        return subject;
	    }

	    @PutMapping("/{id}")
	    public Subject updateSubject(@PathVariable Long id, @RequestBody Subject subjectDetails) {
	        Subject subject = subjectService.getSubjectById(id);
	        if (subject != null) {
	            subject.setName(subjectDetails.getName());
	            subject.setCourse(subjectDetails.getCourse());
	            subjectService.saveSubject(subject);
	            }
	        return subject;
	    }

	    @DeleteMapping("/{id}")
	    public void deleteById(@PathVariable("id") Long id) {
	    	subjectService.deleteSubjectById(id);
	    }
	
	

}
