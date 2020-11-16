package com.cemal.library_system.service;

import com.cemal.library_system.entity.Author;
import com.cemal.library_system.repo.AuthorRepo;
import com.cemal.library_system.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements IAuthorService{
    private final AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo,
                             IBookService bookService) {
        this.authorRepo = authorRepo;

    }

    @Override
    public Author save(Author author) {

        return authorRepo.save(author);
    }


    @Override
    public Author update(Author author ,Long id) {
        Author author1= authorRepo.getOne(id);
        author1.setAuthorName(author.getAuthorName());
        author1.setExplanation(author.getExplanation());
        return authorRepo.save(author1);
    }

    @Override
    public void delete(Long id) {

      authorRepo.deleteById(id);
    }

    @Override
    public List<Author> getAllAuthor() {
      List<Author> author= authorRepo.findAll();
        return author;
    }



    @Override
    public List<Author> getAllAuthor(String keyword) {
        if (keyword != null) {
            return authorRepo.search(keyword);
        }
        return authorRepo.findAll();
    }
}
