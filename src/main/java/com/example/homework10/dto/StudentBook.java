package com.example.homework10.dto;


import com.example.homework10.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
public class StudentBook {

private Integer sId;
private Integer student_id;
private Integer book_id;
private LocalDate localDate;
private Status status;
private LocalDate returnedDate;
private Integer duration;



}
