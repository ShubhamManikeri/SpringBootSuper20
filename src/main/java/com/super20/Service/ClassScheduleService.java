package com.super20.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.super20.DAO.ClassScheduleDao;
import com.super20.Entity.ClassSchedule;


@Service
public class ClassScheduleService {
	
	@Autowired
	private ClassScheduleDao classScheduleDAO;

	
	
	public List<ClassSchedule> getAllClassSchedules() {
		return classScheduleDAO.getAllClassSchedules();
	}


	public ClassSchedule getClassScheduleById(Long id) {
		return classScheduleDAO.getClassScheduleById(id);
	}

	
	public void saveClassSchedule(ClassSchedule classSchedule) {
		classScheduleDAO.saveClassSchedule(classSchedule);
	}

	
	public void deleteClassSchedule(Long id) {
		classScheduleDAO.deleteClassSchedule(id);
	}
}
