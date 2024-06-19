package com.super20.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.super20.Entity.Faculty;
import com.super20.Service.FacultyService;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

	@Autowired
	FacultyService service;
	
	@PostMapping
	public Faculty addFaculty(@RequestBody Faculty faculty)
	{
		return service.addFaculty(faculty);
	}
	
	@GetMapping
	public List<Faculty> getAllFaculty()
	{
		return service.getAllFaculty();
	}
	
	@GetMapping("/{id}")
	public Faculty getFacultyById(@PathVariable("id") Long id)
	{
		return service.getFacultyById(id);
	}
	
	@PutMapping
	public Faculty updateFaculty(@RequestBody Faculty faculty)
	{
		return service.updateFaculty(faculty);
	}
	
	@DeleteMapping("/{id}")
	public void deleteFacultyById(@PathVariable("id") Long id)
	{
		service.deleteFacultyById(id);
	}
}
