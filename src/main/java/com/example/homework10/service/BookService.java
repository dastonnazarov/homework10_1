package com.example.homework10.service;


import com.example.homework10.dto.Book;
import com.example.homework10.entity.BookEntity;
import com.example.homework10.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public void createBook(Book book) {
        BookEntity entity = new BookEntity();
        entity.setId((book.getId()));
        entity.setTitle(book.getTitle());
        entity.setAuthor(book.getAuthor());
        entity.setAmount(book.getAmount());
        entity.setPublishYear(book.getPublishYear());
        entity.setVisible(book.isVisible());
        bookRepository.addBook(entity);
    }

    public List<BookEntity> getBookAll() {
        return bookRepository.getBookAllList();
    }

    public List<BookEntity> getById(Integer id) {
        return bookRepository.getBookById(id);
    }

    public String updateBook(Integer id, BookEntity book) {
        bookRepository.updateBook(id, book);
        return "update success";
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteBook(id);
        System.out.println("delete success");
    }
}
