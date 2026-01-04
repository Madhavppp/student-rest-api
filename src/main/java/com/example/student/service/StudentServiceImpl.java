package com.example.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // CREATE
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // READ ALL
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ BY ID
    @Override
    public Student getStudentById(int id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.orElse(null);
    }

    // UPDATE
    @Override
    public Student updateStudent(int id, Student student) {
        Optional<Student> optional = studentRepository.findById(id);

        if (optional.isPresent()) {
            Student existing = optional.get();
            existing.setName(student.getName());
            existing.setDept(student.getDept());
            return studentRepository.save(existing);
        }
        return null;
    }

    // DELETE
    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
