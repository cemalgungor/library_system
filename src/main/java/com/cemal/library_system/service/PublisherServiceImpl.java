package com.cemal.library_system.service;

import com.cemal.library_system.entity.Author;
import com.cemal.library_system.entity.Publisher;
import com.cemal.library_system.repo.PublisherRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PublisherServiceImpl implements IPublisherService{
    private final PublisherRepo publisherRepo;

    public PublisherServiceImpl(PublisherRepo publisherRepo) {
        this.publisherRepo = publisherRepo;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    @Override
    public void delete(Long id) {
    publisherRepo.deleteById(id);
    }

    @Override
    public Publisher update(Publisher publisher, Long id) {
        Publisher publisher1= publisherRepo.getOne(id);
        publisher1.setPublisherName(publisher.getPublisherName());
        publisher1.setExplanation(publisher.getExplanation());
        return publisherRepo.save(publisher1);
    }

    @Override
    public List<Publisher> getAllPublisher() {
        return publisherRepo.findAll();
    }
}
