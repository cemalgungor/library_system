package com.cemal.library_system.service;

import com.cemal.library_system.entity.Author;
import com.cemal.library_system.entity.Book;

import java.util.List;

public interface IBookService {
    Book save(Book book);
    Book update(Book book);
    Book update(Book book,Long id);
    void delete(Long id);
    List<Book> getAllBooks();
    List<Book> getAllBooks(String keyword);
}
