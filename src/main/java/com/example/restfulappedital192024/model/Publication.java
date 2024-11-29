package com.example.restfulappedital192024.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "publications")
@JsonPropertyOrder({
        "title", "authors", "journal", "publicationYear", "published", "ePublished", "volume",
        "issue", "pages", "doi", "pmid", "labels", "qualifiers", "iuid",
        "url", "doiUrl", "pubMedUrl", "epublished", "issn", "issnL"
})
public class Publication {

    @Id
    @Column(name = "iuid", length = 255)
    private String iuid;

    @Column(name = "title", length = 255)
    private String title;

    @OneToOne(mappedBy = "publication", cascade = CascadeType.ALL)
    @JsonProperty("authors")
    private Author author;

    @Column(name = "journal", length = 255)
    private String journal;


    @Column(name = "issn", length = 9)
    private String issn;

    @Column(name = "issn_l", length = 9)
    private String issnL;

    @JsonProperty("year")
    @Column(name = "publication_year")
    private int publicationYear;

    @Column(name = "published")
    @Temporal(TemporalType.DATE)
    private Date published;

    @Column(name = "e_published")
    @Temporal(TemporalType.DATE)
    private Date ePublished;

    @Column(name = "volume")
    private Integer volume;

    @Column(name = "issue", length = 50)
    private String issue;

    @Column(name = "pages", length = 50)
    private String pages;

    @Column(name = "doi", length = 255)
    private String doi;

    @Column(name = "pmid")
    private Integer pmid;

    @ManyToMany
    @JoinTable(
            name = "publication_labels",
            joinColumns = @JoinColumn(name = "publication_id", referencedColumnName = "iuid"),
            inverseJoinColumns = @JoinColumn(name = "label_id", referencedColumnName = "id")
    )
    private Set<Label> labels;

    @ManyToMany
    @JoinTable(
            name = "publication_qualifiers",
            joinColumns = @JoinColumn(name = "publication_id", referencedColumnName = "iuid"),
            inverseJoinColumns = @JoinColumn(name = "qualifier_id", referencedColumnName = "id")
    )
    private Set<Qualifier> qualifiers;

    @Column(name = "url", length = 255)
    private String url;

    @Column(name = "doi_url", length = 255)
    private String doiUrl;

    @Column(name = "pub_med_url", length = 255)
    private String pubMedUrl;

    public Publication() {
    }

    public String getIuid() {
        return iuid;
    }

    public void setIuid(String iuid) {
        this.iuid = iuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getIssnL() {
        return issnL;
    }

    public void setIssnL(String issnL) {
        this.issnL = issnL;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public Date getEPublished() {
        return ePublished;
    }

    public void setEPublished(Date ePublished) {
        this.ePublished = ePublished;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public Integer getPmid() {
        return pmid;
    }

    public void setPmid(Integer pmid) {
        this.pmid = pmid;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Date getePublished() {
        return ePublished;
    }

    public void setePublished(Date ePublished) {
        this.ePublished = ePublished;
    }

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }

    public Set<Qualifier> getQualifiers() {
        return qualifiers;
    }

    public void setQualifiers(Set<Qualifier> qualifiers) {
        this.qualifiers = qualifiers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDoiUrl() {
        return doiUrl;
    }

    public void setDoiUrl(String doiUrl) {
        this.doiUrl = doiUrl;
    }

    public String getPubMedUrl() {
        return pubMedUrl;
    }

    public void setPubMedUrl(String pubMedUrl) {
        this.pubMedUrl = pubMedUrl;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
