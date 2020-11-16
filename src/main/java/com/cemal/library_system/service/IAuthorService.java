package com.cemal.library_system.service;

import com.cemal.library_system.entity.Author;

import java.util.List;

public interface IAuthorService {
    Author save(Author author);

    Author update(Author author,Long id);
    void delete(Long id);
    List<Author> getAllAuthor();
    List<Author>  getAllAuthor( String keyword);

}
