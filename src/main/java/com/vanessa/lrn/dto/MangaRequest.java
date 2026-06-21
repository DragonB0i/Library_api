package com.vanessa.lrn.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MangaRequest {

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Volume cannot be empty")
    private String volume;

    @NotBlank(message = "Author cannot be empty")
    private String author;

    @NotNull(message = "Price cannot be null")
    @Min(value = 1, message = "Price must be greater than 0")
    private Integer price;

    public MangaRequest() {
    }

    public MangaRequest(String title,
                        String volume,
                        String author,
                        Integer price) {

        this.title = title;
        this.volume = volume;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}