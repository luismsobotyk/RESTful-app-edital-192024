package com.example.restfulappedital192024.model;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @Column(name = "iuid", length = 255)
    private String iuid;

    @Column(name = "author_name", length = 255, nullable = false)
    private String authorName;

    @OneToOne
    @MapsId
    @JoinColumn(name = "iuid")
    private Publication publication;

    // Getters and Setters
    public String getIuid() {
        return iuid;
    }

    public void setIuid(String iuid) {
        this.iuid = iuid;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
}
