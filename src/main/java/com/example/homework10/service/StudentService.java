package com.example.homework10.service;

import com.example.homework10.dto.Student;
import com.example.homework10.entity.BookEntity;
import com.example.homework10.entity.StudentEntity;
import com.example.homework10.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void createStudent(Student student) {
        StudentEntity entity = new StudentEntity();
        entity.setId(student.getId());
        entity.setName(student.getName());
        entity.setSurname(student.getSurname());
        entity.setPhone(student.getPhone());
        entity.setCreatedDate(student.getCreatedDate());
        entity.setRole(student.getRole());
        entity.setVisible(student.isVisible());
        studentRepository.saveStudent(entity);
    }


    public List<StudentEntity> getStudentAll() {
       return   studentRepository.getStudentList();
    }

    public List<StudentEntity> getById(Integer id) {
        return studentRepository.getId(id);
    }

    public String update(Integer id, StudentEntity entity) {
         studentRepository.updateStudent(id,entity);
         return "update";
    }

    public void delete(Integer id) {
        studentRepository.deleteStudent(id);
    }
}
