package com.example.restfulappedital192024.repository;

import com.example.restfulappedital192024.model.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, String> {

    List<Publication> findByPublicationYear(int publicationYear);
    Publication findByDoi(String doi);

}
