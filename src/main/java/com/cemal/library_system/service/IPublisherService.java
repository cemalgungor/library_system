package com.cemal.library_system.service;

import com.cemal.library_system.entity.Author;
import com.cemal.library_system.entity.Book;
import com.cemal.library_system.entity.Publisher;

import java.util.List;

public interface IPublisherService {
    Publisher save(Publisher publisher);
    Publisher update(Publisher publisher);
    void delete(Long id);
    Publisher update(Publisher publisher, Long id);
    List<Publisher> getAllPublisher();
}
