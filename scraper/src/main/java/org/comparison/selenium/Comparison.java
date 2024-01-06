package org.comparison.selenium;

import javax.persistence.*;

/** Class representing a student */
@Entity
@Table(name="comparison")
public class Comparison {
    //ID of student
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "price")
    float price;

    @Column(name = "site_url")
    String site_url;


    @ManyToOne
    @JoinColumn(name="isbn", nullable=false)
    Manga_Volume manga_volume;

    public Manga_Volume getManga_volume() { return manga_volume; }
    public void setManga_volume(Manga_Volume manga_volume) {this.manga_volume = manga_volume;}

    //Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public float getPrice(){
        return price;
    }
    public void setPrice(float price){
        this.price = price;
    }

    public String getSite_url(){
        return site_url;
    }
    public void setSite_url(String site_url){
        this.site_url = site_url;
    }

}


