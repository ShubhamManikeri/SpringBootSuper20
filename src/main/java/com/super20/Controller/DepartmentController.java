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

import com.super20.Entity.Department;
import com.super20.Service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	DepartmentService service;
	
	@PostMapping
	public Department addDepartment(@RequestBody Department department)
	{
		return service.addDepartment(department);
	}
	
	@GetMapping
	public List<Department> getAllDepartment()
	{
		return service.getAllDepartment();
	}
	
	@GetMapping("/{dept_id}")
	public Department getDepartmentById(@PathVariable("dept_id") Long dept_id)
	{
		return service.getDepartmentById(dept_id);
	}
	
	@PutMapping
	public Department updateDepartment(@RequestBody Department department)
	{
		return service.updateDepartment(department);
	}
	
	@DeleteMapping("/{dept_id}")
	public void eleteDepartmentById(@PathVariable("dept_id") Long dept_id)
	{
		service.deleteDepartmentById(dept_id);
	}

}
