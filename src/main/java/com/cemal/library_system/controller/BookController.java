package com.cemal.library_system.controller;

import com.cemal.library_system.entity.Author;
import com.cemal.library_system.entity.Book;
import com.cemal.library_system.entity.Publisher;
import com.cemal.library_system.repo.AuthorRepo;
import com.cemal.library_system.repo.PublisherRepo;
import com.cemal.library_system.service.BookServiceImpl;
import com.cemal.library_system.service.IAuthorService;
import com.cemal.library_system.service.IPublisherService;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookServiceImpl bookService;
    private final IAuthorService authorService;
    private final IPublisherService publisherService;
    private  final AuthorRepo authorRepo;
    private  final PublisherRepo publisherRepo;

    public BookController(BookServiceImpl bookService,
                          AuthorRepo authorRepo,
                          IAuthorService authorService,
                          IPublisherService publisherService,
                          PublisherRepo publisherRepo) {
        this.bookService = bookService;
        this.authorService=authorService;
        this.publisherService=publisherService;
        this.authorRepo=authorRepo;
        this.publisherRepo=publisherRepo;
    }
    @RequestMapping
    public String getAllBooks(Model model, @Param("keyword") String keyword)
    {
        List<Book> books = bookService.getAllBooks(keyword);
        List<Author> authors = authorRepo.findAll();
        List<Publisher> publishers = publisherRepo.findAll();
        model.addAttribute("authors", authors);
        model.addAttribute("publishers", publishers);
        model.addAttribute("keyword", keyword);
        model.addAttribute("books", books);
        model.addAttribute("bookForm", new Book());
        return "book";
    }


    @RequestMapping(path = "/delete/{id}")
    public String deleteAuthorById(Model model, @PathVariable("id") Long id)
    {
        bookService.delete(id);
        return "redirect:/book";
    }
    @RequestMapping(path = "/createBook", method = RequestMethod.POST)
    public String createBook(@ModelAttribute(value="bookForm") Book book)
    {
        bookService.save(book);
        return "redirect:/book";
    }

    @RequestMapping(path = "/updateBook/{id}", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute(value="bookForm") Book book,@PathVariable("id") Long id )
    {

        bookService.update(book,id);
        return "redirect:/book";
    }
}
