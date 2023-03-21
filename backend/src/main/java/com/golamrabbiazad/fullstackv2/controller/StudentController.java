package com.golamrabbiazad.fullstackv2.controller;

import com.golamrabbiazad.fullstackv2.exception.BadRequestExeception;
import com.golamrabbiazad.fullstackv2.model.Student;
import com.golamrabbiazad.fullstackv2.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @PostMapping("/create")
    public void addStudent(@Valid @RequestBody Student student) throws BadRequestExeception {
        studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student getSingleStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
