package com.vanessa.lrn;

import jakarta.persistence.*;

@Entity
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String volume;
    private String author;
    private int price;

    public Manga() {
    }

    public Manga(String title,
                 String volume,
                 String author,
                 int price) {

        this.title = title;
        this.volume = volume;
        this.author = author;
        this.price = price;
    }

    // ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Volume
    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    // Author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Price
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}