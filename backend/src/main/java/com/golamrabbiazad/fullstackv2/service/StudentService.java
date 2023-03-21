package com.golamrabbiazad.fullstackv2.service;

import com.golamrabbiazad.fullstackv2.exception.BadRequestExeception;
import com.golamrabbiazad.fullstackv2.exception.StudentNotFoundException;
import com.golamrabbiazad.fullstackv2.model.Student;
import com.golamrabbiazad.fullstackv2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) throws BadRequestExeception {
        Boolean existsEmail = studentRepository.selectExistsEmail(student.getEmail());
        if (existsEmail) {
            throw new BadRequestExeception("Email " + student.getEmail() + " has been taken.");
        }
        studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("student not found with ID: " + id));
    }

    public void deleteById(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException("Student with ID: " + studentId + " does not exists.");
        }
        studentRepository.deleteById(studentId);
    }
}
