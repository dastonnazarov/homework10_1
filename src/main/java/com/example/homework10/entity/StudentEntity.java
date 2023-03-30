package com.example.homework10.entity;


import com.example.homework10.enums.StudentRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@ToString
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "createdDate")
    private LocalDate createdDate;

    @Column(name = "role")
    private StudentRole role;

    @Column(name = "visible")
    private boolean visible;

}