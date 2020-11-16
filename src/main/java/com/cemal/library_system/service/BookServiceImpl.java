package com.cemal.library_system.service;

import com.cemal.library_system.entity.Author;
import com.cemal.library_system.entity.Book;
import com.cemal.library_system.entity.Publisher;
import com.cemal.library_system.repo.AuthorRepo;
import com.cemal.library_system.repo.BookRepo;
import com.cemal.library_system.repo.PublisherRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements  IBookService {
    private final BookRepo bookRepo;

    private final AuthorRepo authorRepo;
    private final PublisherRepo publisherRepo;

    public BookServiceImpl(BookRepo bookRepo,
                           AuthorRepo authorRepo,
                           PublisherRepo publisherRepo
                        ) {
        this.bookRepo = bookRepo;
        this.authorRepo=authorRepo;
        this.publisherRepo=publisherRepo;

    }

    @Override
    public Book save(Book book) {
        book.getAuthor().setId((book.getAuthor().getId()));
       return bookRepo.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book update(Book book, Long id) {
        Book book1= bookRepo.getOne(id);
        book1.setAuthor(book.getAuthor());
        book1.setBookName(book.getBookName());
        book1.setBookSeriesName(book.getBookSeriesName());
        book1.setBookSubname(book.getBookSubname());
        book1.setIsbnNumber(book.getIsbnNumber());
        book1.setPublisher(book.getPublisher());
        book1.setExplanation(book.getExplanation());
        return bookRepo.save(book1);
    }

    @Override
    public void delete(Long id) {
        bookRepo.deleteById(id);
    }


    @Override
    public List<Book> getAllBooks() {

        return bookRepo.findAll();
    }
    @Override
    public List<Book> getAllBooks(String keyword) {
        if (keyword != null) {
            return bookRepo.search(keyword);
        }

        return bookRepo.findAll();
    }
}
