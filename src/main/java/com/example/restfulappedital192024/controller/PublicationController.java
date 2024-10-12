package com.example.restfulappedital192024.controller;

import com.example.restfulappedital192024.model.Greeting;
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

    @RequestMapping("/test")
    public Greeting greeting(@RequestParam(value= "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/findByDOI/{doi}")
    public Publication findByDOI(@PathVariable("doi") String doi){
        return service.findByDOI(doi);
    }

    @GetMapping("/findByYear/{year}")
    public List<Publication> findByYear(@PathVariable("year") int year){
        return service.findByYear(year);
    }




}
