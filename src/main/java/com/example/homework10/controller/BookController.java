package com.example.homework10.controller;

import com.example.homework10.dto.Book;
import com.example.homework10.entity.BookEntity;
import com.example.homework10.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping( "/create")
    public void createBook(@RequestBody Book book) {
        bookService.createBook(book);

    }

    @GetMapping( "/bookList")
    public List<BookEntity> bookList() {
       return bookService.getBookAll();
    }

    @GetMapping( "/get/{id}")
    public List<BookEntity> getBookId(@PathVariable ("id") Integer id) {
       return bookService.getById(id);
    }


    @PutMapping( "/update/{id}")
    public void  update(@PathVariable("id") Integer id, @RequestBody BookEntity book) {
       bookService.updateBook(id,book);
    }

    @DeleteMapping( "/delete/{id}")
    public void  delete(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
    }


}
