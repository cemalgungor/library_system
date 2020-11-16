package com.cemal.library_system.controller;

import com.cemal.library_system.entity.Author;
import com.cemal.library_system.entity.Publisher;
import com.cemal.library_system.service.PublisherServiceImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    private final PublisherServiceImpl publisherService;

    public PublisherController(PublisherServiceImpl publisherService) {
        this.publisherService = publisherService;
    }
    @RequestMapping
    public String getAllPublisher(Model model, @Param("keyword") String keyword)
    {
        List<Publisher> publishers = publisherService.getAllPublisher();
        model.addAttribute("publishers", publishers);
        model.addAttribute("keyword", keyword);
        model.addAttribute("publisherForm", new Publisher());
        return "publisher";
    }
    @RequestMapping(path = "/delete/{id}")
    public String deletePublisherById(Model model, @PathVariable("id") Long id)
    {
        publisherService.delete(id);
        return "redirect:/publisher";
    }
    @RequestMapping(path = "/createPublisher", method = RequestMethod.POST)
    public String createPublisher(@ModelAttribute(value="publisherForm") Publisher publisher)
    {

        publisherService.save(publisher);
        return "redirect:/publisher";
    }
    @RequestMapping(path = "/updatePublisher/{id}", method = RequestMethod.POST)
    public String updatePublisher(@ModelAttribute(value="publisherForm") Publisher publisher,@PathVariable("id") Long id )
    {

        publisherService.update(publisher,id);
        return "redirect:/publisher";
    }
}
