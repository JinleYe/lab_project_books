package com.bnta.lab_project.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
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

    // @ManyToMany(mappedBy = "books", cascade = CascadeType.REMOVE) cascade not that good
    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties(value = "books")
    private List<Author> authors;

    // @ManyToMany(mappedBy = "books", cascade = CascadeType.REMOVE) cascade not that good
    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties(value = "books")
    private List<Category> categories;

    // one to many is okay to use cascade when deleting book
    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
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


    // remove and add authors, categories, reviews
    public void addAuthor(Author author){
        this.authors.add(author);
    }

    public void removeAuthor(Author author){
        this.authors.remove(author);
    }

    public void addCategory(Category category){
        this.categories.add(category);
    }

    public void removeCategory(Category category){
        this.categories.remove(category);
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }

    public void removeReview(Review review){
        this.reviews.remove(review);
    }


}
