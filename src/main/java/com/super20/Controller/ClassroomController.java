package com.super20.Controller;

import java.util.List;
import java.util.Optional;

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

import com.super20.Entity.Classroom;
import com.super20.Service.ClassroomService;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {
	
	
	
	@Autowired
    private ClassroomService classroomService;

    @GetMapping
    public List<Classroom> getAllClassrooms() {
        return classroomService.getAllClassrooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getClassroomById(@PathVariable("id") Long id) {
        Optional<Classroom> classroom = classroomService.getClassroomById(id);
        if (classroom.isPresent()) {
            return ResponseEntity.ok(classroom.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Classroom createClassroom(@RequestBody Classroom classroom) {
        return classroomService.saveClassroom(classroom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classroom> updateClassroom(@PathVariable Long id, @RequestBody Classroom classroomDetails) {
        Optional<Classroom> classroomOptional = classroomService.getClassroomById(id);
        if (classroomOptional.isPresent()) {
            Classroom classroom = classroomOptional.get();
            classroom.setName(classroomDetails.getName());
            return ResponseEntity.ok(classroomService.saveClassroom(classroom));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable Long id) {
        if (classroomService.getClassroomById(id).isPresent()) {
            classroomService.deleteClassroom(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
