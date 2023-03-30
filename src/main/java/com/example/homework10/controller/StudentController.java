package com.example.homework10.controller;

import com.example.homework10.dto.Student;
import com.example.homework10.entity.BookEntity;
import com.example.homework10.entity.StudentEntity;
import com.example.homework10.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @GetMapping( "/studentList")
    public List<StudentEntity> studentList() {
        return studentService.getStudentAll();
    }

    @GetMapping("/getById/{id}")
    public List<StudentEntity> getById(@PathVariable Integer id){
          return  studentService.getById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody StudentEntity entity){
         studentService.update(id,entity);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        studentService.delete(id);
    }
}
