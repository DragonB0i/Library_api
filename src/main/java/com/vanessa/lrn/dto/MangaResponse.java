package com.vanessa.lrn.dto;

public class MangaResponse {

    private Long id;
    private String title;
    private String volume;
    private String author;
    private int price;

    public MangaResponse(Long id,
                         String title,
                         String volume,
                         String author,
                         int price) {

        this.id = id;
        this.title = title;
        this.volume = volume;
        this.author = author;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getVolume() {
        return volume;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }
}