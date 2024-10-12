package com.example.restfulappedital192024.model;

import jakarta.persistence.*;

@Entity
@Table(name = "publication_qualifiers")
public class PublicationQualifier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "publication_id", referencedColumnName = "iuid")
    private Publication publication;

    @ManyToOne
    @JoinColumn(name = "qualifier_id", referencedColumnName = "id")
    private Qualifier qualifier;


}
