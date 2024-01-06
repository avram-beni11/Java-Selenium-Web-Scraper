package org.comparison.selenium;

import javax.persistence.*;

/** Class representing a manga  */
@Entity
@Table(name="manga")
public class Manga {
    //Id of the university
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    //Description of the manga
    @Column(name = "description")
    String description;

    //Cover URL of Manga
    @Column(name = "cover_url")
    String cover_url;

    //Author URL of Manga
    @Column(name = "author")
    String author;

    //Publisher URL of Manga
    @Column(name = "publisher")
    String publisher;

    //Title URL of Manga
    @Column(name = "title" )
    String title;

    public int getId() {return id;}
    public void setId(int id) { this.id = id;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getCover_url() {return cover_url;}
    public void setCover_url(String cover_url) {this.cover_url = cover_url;}

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public String getPublisher() {return publisher;}
    public void setPublisher(String publisher) {this.publisher = publisher;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
}
