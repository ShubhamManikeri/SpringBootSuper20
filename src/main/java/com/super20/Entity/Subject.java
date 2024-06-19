package com.super20.Entity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "course_id")
//	@NotNull
	@Column(name = "course_id", nullable = false)
	private Long course_id;
	private String name;
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subject( Long course_id, String name) {
		super();
		this.course_id = course_id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCourse() {
		return course_id;
	}
	public void setCourse(Long course_id) {
		this.course_id = course_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Subject [id=" + id + ", course_id=" + course_id + ", name=" + name + "]";
	}
	
	

}
