package com.example.crudstudent.service;

import com.example.crudstudent.model.Student;
import com.example.crudstudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // Get All
    public List<Student> getAll() {
        return repository.findAll();
    }

    // Get by ID
    public Student getById(int id) {
        return repository.findById(id).orElse(null);
    }

    // Add
    public Student save(Student student) {
        return repository.save(student);
    }

    // Delete
    public void delete(int id) {
        repository.deleteById(id);
    }

    // Update
    public Student update(int id, Student student) {
        Student old = getById(id);
        if (old != null) {
            old.setName(student.getName());
            old.setAge(student.getAge());
            old.setGender(student.getGender());
            old.setEmail(student.getEmail());
            return repository.save(old);
        }
        return null;
    }

    // Search by name
    public List<Student> search(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}
