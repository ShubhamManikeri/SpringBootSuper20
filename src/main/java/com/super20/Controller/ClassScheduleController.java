package com.super20.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.super20.Entity.ClassSchedule;
import com.super20.Service.ClassScheduleService;

@RestController
@RequestMapping("/api/classSchedules")
public class ClassScheduleController {
	  @Autowired
	    private ClassScheduleService classScheduleService;

	    @GetMapping
	    public List<ClassSchedule> getAllClassSchedules() {
	        return classScheduleService.getAllClassSchedules();
	    }

	    @GetMapping("/{id}")
	    public ClassSchedule getClassScheduleById(@PathVariable Long id) {
	        return classScheduleService.getClassScheduleById(id);
	    }

	    @PostMapping
	    public ClassSchedule createClassSchedule(@RequestBody ClassSchedule classSchedule) {
	        classScheduleService.saveClassSchedule(classSchedule);
	        return classSchedule;
	    }

	    @PutMapping("/{id}")
	    public ClassSchedule updateClassSchedule(@PathVariable Long id, @RequestBody ClassSchedule classScheduleDetails) {
	        ClassSchedule classSchedule = classScheduleService.getClassScheduleById(id);
	        if (classSchedule != null) {
	            classSchedule.setSubjectId(classScheduleDetails.getSubjectId());
	            classSchedule.setClassroomId(classScheduleDetails.getClassroomId());
	            classSchedule.setDayOfWeek(classScheduleDetails.getDayOfWeek());
	            classSchedule.setStartTime(classScheduleDetails.getStartTime());
	            classSchedule.setEndTime(classScheduleDetails.getEndTime());
	            classScheduleService.saveClassSchedule(classSchedule);
	        }
	        return classSchedule;
	    }

	    @DeleteMapping("/{id}")
	    public void deleteClassSchedule(@PathVariable Long id) {
	        classScheduleService.deleteClassSchedule(id);
	    }

}
