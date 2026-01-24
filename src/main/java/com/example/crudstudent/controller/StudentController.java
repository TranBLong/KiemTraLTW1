package com.example.crudstudent.controller;

import com.example.crudstudent.model.Student;
import com.example.crudstudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*") // cho phép gọi từ web
public class StudentController {

    @Autowired
    private StudentService studentService;

    // YÊU CẦU 1: Thêm sinh viên (POST)
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    // YÊU CẦU 2: Xóa sinh viên
    @PostMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.delete(id);
    }

    // YÊU CẦU 3: Tìm kiếm sinh viên theo tên
    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return studentService.search(name);
    }

    // YÊU CẦU 4: Lấy sinh viên theo ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return studentService.getById(id);
    }

    // YÊU CẦU 5: Lấy danh sách sinh viên (GET ALL)
    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    // YÊU CẦU 6: Cập nhật sinh viên
    @PostMapping("/update/{id}")
    public Student update(@PathVariable int id, @RequestBody Student student) {
        return studentService.update(id, student);
    }
}
