package com.example.restfulappedital192024.services;

import com.example.restfulappedital192024.exceptions.ResourceNotFoundException;
import com.example.restfulappedital192024.model.Publication;
import com.example.restfulappedital192024.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PublicationServices {

    @Autowired
    PublicationRepository repository;

    public List<Publication> findByPublicationYear(int year){
        return repository.findByPublicationYear(year);
    }

    public Publication findByDOI(String doi){
       return repository.findByDoi(doi);
    }


    public Publication mockPublication(int i, int year, String doi){
        Publication publication = new Publication();
        publication.setTitle("Title "+i);
        publication.setIuid("IUID "+i);
        publication.setJournal("Journal "+i);
        publication.setIssn("ISSN "+i);
        publication.setIssnL("ISSNL "+i);
        publication.setPublished(new Date());
        publication.setEPublished(new Date());
        publication.setVolume(i);
        publication.setIssue("Issue "+i);
        if(!doi.isEmpty()){
            publication.setDoi(doi);
        }else{
            publication.setDoi("DOI "+i);
        }
        publication.setPmid(i);
        publication.setUrl("URL http://"+i+".com.br");
        publication.setDoiUrl("DOI URL http://"+i+".com.br");
        publication.setPubMedUrl("PUM MED URL http://"+i+".com.br");
        publication.setPublicationYear(year);
        publication.setPages("PAGES: "+i);
        return publication;
    }

}
