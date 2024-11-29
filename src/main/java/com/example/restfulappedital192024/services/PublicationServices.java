package com.example.restfulappedital192024.services;

import com.example.restfulappedital192024.exceptions.ResourceNotFoundException;
import com.example.restfulappedital192024.model.Label;
import com.example.restfulappedital192024.model.Publication;
import com.example.restfulappedital192024.model.Qualifier;
import com.example.restfulappedital192024.repository.LabelRepository;
import com.example.restfulappedital192024.repository.PublicationRepository;
import com.example.restfulappedital192024.repository.QualifierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PublicationServices {

    @Autowired
    PublicationRepository repository;

    @Autowired
    LabelRepository labelRepository;
    @Autowired
    QualifierRepository qualifierRepository;

    public List<Publication> findByPublicationYear(int year){
        List<Publication> publications = repository.findByPublicationYear(year);
        if (publications.isEmpty()) {
            throw new ResourceNotFoundException("Nenhuma publicação encontrada para o ano informado!");
        }
        return repository.findByPublicationYear(year);
    }

    public Publication findByDOI(String doi){
        Publication publication= repository.findByDoi(doi);
        if(publication==null){
            throw new ResourceNotFoundException("Nenhuma publicação encontrada para o DOI informado!");
        }
        return publication;
    }

    public Publication create(){
        Publication publication = mockPublication(1, 2020, "asdfasdfasd");

        Label a= new Label();
        a.setName("NGI Uppsala (Uppsala Genome Center)");
        Label b= new Label();
        b.setName("National Genomics Infrastructure");
        a= labelRepository.save(a);
        b= labelRepository.save(b);
        Set<Label> labels= new HashSet<>();
        labels.add(a);
        labels.add(b);
        publication.setLabels(labels);

        Qualifier q1 = new Qualifier();
        q1.setName("Collaborative");
        Qualifier q2 = new Qualifier();
        q2.setName("Service");
        q1= qualifierRepository.save(q1);
        q2= qualifierRepository.save(q2);
        Set<Qualifier> qualifiers= new HashSet<>();
        qualifiers.add(q1);
        qualifiers.add(q2);
        publication.setQualifiers(qualifiers);

        //a.getPublications().add(publication);
        //b.getPublications().add(publication);
        return repository.save(publication);
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
