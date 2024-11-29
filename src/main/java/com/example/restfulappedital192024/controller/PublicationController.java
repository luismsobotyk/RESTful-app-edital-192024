package com.example.restfulappedital192024.controller;

import com.example.restfulappedital192024.model.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.restfulappedital192024.services.PublicationServices;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PublicationController {

    private static final String template = "Hello %s!";
    private static final AtomicLong counter = new AtomicLong();

    @Autowired
    private PublicationServices service;

    @GetMapping("/findByDoi")
    public Publication findByDOI(@RequestParam String doi){
        // Usage example: http://localhost:8080/findByDoi?doi=10.1371/journal.pgen.1002412
        return service.findByDOI(doi);
    }

    @GetMapping("/findByYear/{year}")
    public List<Publication> findByYear(@PathVariable("year") int year){
        return service.findByPublicationYear(year);
    }

    @GetMapping("/create")
    public Publication create(){
        return service.create();
    }




}
