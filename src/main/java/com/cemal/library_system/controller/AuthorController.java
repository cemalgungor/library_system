package com.cemal.library_system.controller;

import com.cemal.library_system.entity.Author;
import com.cemal.library_system.entity.Book;
import com.cemal.library_system.service.IAuthorService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController  {

    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping
    public String getAllAuthors(Model model, @Param("keyword") String keyword)
    {
        List<Author> authors = authorService.getAllAuthor(keyword);

        model.addAttribute("authors", authors);
        model.addAttribute("keyword", keyword);
        model.addAttribute("authorForm", new Author());
        return "author";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteAuthorById(Model model, @PathVariable("id") Long id)
    {
       authorService.delete(id);
        return "redirect:/author";
    }
    @RequestMapping(path = "/createAuthor", method = RequestMethod.POST)
    public String createAuthor(@ModelAttribute(value="authorForm") Author author)
    {

        authorService.save(author);
        return "redirect:/author";
    }
    @RequestMapping(path = "/updateAuthor/{id}", method = RequestMethod.POST)
    public String updateAuthor(@ModelAttribute(value="authorForm") Author author,@PathVariable("id") Long id )
    {

        authorService.update(author,id);
        return "redirect:/author";
    }
}
