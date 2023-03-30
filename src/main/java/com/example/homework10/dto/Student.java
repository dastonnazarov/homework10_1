package com.example.homework10.dto;


import com.example.homework10.enums.StudentRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
public class Student {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private LocalDate createdDate;
    private StudentRole role;
    private boolean visible;


    public Student() {
    }




}