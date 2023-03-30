package com.example.homework10.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
public class Book {

    private Integer id;
    private String title;
    private String author;
    private LocalDate publishYear;
    private Double amount;
    private boolean visible;




}
