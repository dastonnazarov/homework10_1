package com.example.homework10.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@ToString
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publishYear")
    private LocalDate publishYear;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "visible")
    private boolean visible;




}
