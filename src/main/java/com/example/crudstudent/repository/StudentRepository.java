package com.example.crudstudent.repository;

import com.example.crudstudent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Tìm kiếm theo tên (ignore hoa thường)
    List<Student> findByNameContainingIgnoreCase(String name);
}
