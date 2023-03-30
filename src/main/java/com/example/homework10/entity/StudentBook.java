package com.example.homework10.entity;


import com.example.homework10.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@ToString
@Table(name = "studentbook")
public class StudentBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sId;

    @Column(name = "student_id")
    private Integer student_id;

    @Column(name = "book_id")
    private Integer book_id;

    @Column(name = "localDate")
    private LocalDate localDate;

    @Column(name = "status")
    private Status status;

    @Column(name = "returnedDate")
    private LocalDate returnedDate;

    @Column(name = "duration")
    private Integer duration;


}
