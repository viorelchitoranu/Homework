package com.devmind.springapp.homeworkc20.controllers;

import com.devmind.springapp.homeworkc20.models.Adresa;
import com.devmind.springapp.homeworkc20.models.Student;
import com.devmind.springapp.homeworkc20.repository.StudentRepository;
import com.devmind.springapp.homeworkc20.service.UnivService;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {


    private final UnivService univService;

    @Autowired
    public StudentController(UnivService univService) {
        this.univService = univService;
    }


    // punctul 2

    @PostMapping("/enroll")
    public ResponseEntity<Student> enrollStudentToMaterii( @RequestParam Integer studentId, @RequestParam Integer materieId) {
        Student updatedStudent = univService.enrollStudentToMaterii( studentId, materieId);
        return ResponseEntity.ok(updatedStudent);
    }

    // punctul 3

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return univService.addStudentWithAdress(student);
    }

    // punctul 4

    @PutMapping("/{studentId}/adresa")
    public Student updateStudentAdress(@PathVariable Integer studentId,@RequestBody Adresa adresa) {
        return univService.updateStudentAdress(studentId, adresa);
    }

    // punctul 5

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer studentId) {
        univService.deleteStudentAndRelations(studentId);
        return ResponseEntity.noContent().build();
    }




}
