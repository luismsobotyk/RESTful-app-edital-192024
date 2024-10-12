package com.example.restfulappedital192024.model;

import jakarta.persistence.*;

@Entity
@Table(name = "publication_labels")
public class PublicationLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "publication_id", referencedColumnName = "iuid")
    private Publication publication;

    @ManyToOne
    @JoinColumn(name = "label_id", referencedColumnName = "id")
    private Label label;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}