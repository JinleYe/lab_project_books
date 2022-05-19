package com.bnta.lab_project.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private LocalDate publishDate;

    @Column
    private Float price;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties(value = "books")
    private List<Author> authors;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties(value = "books")
    private List<Category> categories;

    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties(value = "book")
    private List<Review> reviews;

    protected Book(){}

    public Book(String title, LocalDate publishDate, Float price) {
        this.title = title;
        this.publishDate = publishDate;
        this.price = price;
        this.authors = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public Float getPrice() {
        return price;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setReviews(List<Review> comments) {
        this.reviews = comments;
    }



}
