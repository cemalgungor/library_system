package com.cemal.library_system.repo;

import com.cemal.library_system.entity.Author;
import com.cemal.library_system.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    @Query("SELECT b FROM Book b WHERE CONCAT(b.bookName, b.author.authorName,b.bookSeriesName,b.isbnNumber) LIKE %?1%")
    public List<Book> search(String keyword);
}
