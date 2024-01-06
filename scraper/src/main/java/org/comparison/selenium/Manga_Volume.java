package org.comparison.selenium;

import javax.persistence.*;

/** Class modelling a degree programme */
@Entity
@Table(name="manga_volume")
public class Manga_Volume {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //ISBN of the manga
    @Id
    @Column(name = "isbn")
    long isbn;


    @ManyToOne
    @JoinColumn(name = "manga_id", nullable = false)
    Manga manga;

    //Cover URL of Manga
    @Column(name = "format")
    String format;

    public Manga getManga() { return manga; }
    public void setManga(Manga manga) { this.manga = manga; }

    public long getISBN() {return isbn;}
    public void setISBN(long isbn) { this.isbn = isbn;}

    public String getFormat() {return format;}
    public void setFormat(String format) { this.format = format;}
}


