package com.cemal.library_system.repo;

import com.cemal.library_system.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {
    @Query("SELECT a FROM Author a WHERE CONCAT(a.authorName, a.explanation) LIKE %?1%")
    public List<Author> search(String keyword);


}
