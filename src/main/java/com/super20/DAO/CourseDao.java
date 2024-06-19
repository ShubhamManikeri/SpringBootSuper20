package com.super20.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.super20.Entity.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

}
